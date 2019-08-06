import java.util.*;

public class Main {
	static int N, L, R, res, count;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		arr = new int[N][N];
		chk = new boolean[N][N];
		res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		Queue<Pair> tmp = new LinkedList<>();
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i = 0; i < N; i++)
				Arrays.fill(chk[i], false);
			tmp.clear();
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(!chk[i][j])
					{
						int sum = 0, cnt = 1;
						Queue<Pair> q = new LinkedList<>();
						q.add(new Pair(i, j));
						chk[i][j] = true;
						while(!q.isEmpty())
						{
							Pair p = q.poll();
							tmp.add(p);
							sum += arr[p.x][p.y];
							for(int k = 0; k < 4; k++)
							{
								int nx = p.x + dx[k], ny = p.y + dy[k];
								if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny]) continue;
								int num = Math.abs(arr[p.x][p.y] - arr[nx][ny]);
								if(num >= L && num <= R)
								{
									flag = true;
									chk[nx][ny] = true;
									q.add(new Pair(nx, ny));
									cnt++;
								}
							}
						}
						if(flag)
						{
							while(!tmp.isEmpty())
							{
								Pair t = tmp.poll();
								arr[t.x][t.y] = sum / cnt;
							}
						}
						tmp.clear();
					}
			if(flag)
				res++;
		}
		System.out.println(res);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}