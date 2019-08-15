import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int[][] chk = new int[N][M];
		Pair[] tmp = new Pair[4];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '*') q.offer(new Pair(i, j));
		}
		Queue<String> ans = new LinkedList<String>();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			for(int i = 0; i < 4; i++)
				tmp[i] = new Pair(p.x, p.y);
			int cnt = 0;
			boolean flag = true;
			while(flag)
			{
				for(int i = 0; i < 4; i++)
				{
					int nx = tmp[i].x + dx[i], ny = tmp[i].y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.')
					{
						flag = false;
						break;
					}
				}
				if(flag)
				{
					cnt++;
					ans.offer((p.x+1) + " " + (p.y+1) + " " + cnt);
					if(cnt == 1) chk[p.x][p.y]++;
					for(int i = 0; i < 4; i++)
					{
						int nx = tmp[i].x + dx[i], ny = tmp[i].y + dy[i];
						chk[nx][ny]++;
						tmp[i].x = nx;
						tmp[i].y = ny;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
//				System.out.print(chk[i][j] + " ");
				if(chk[i][j] == 0 && arr[i][j] == '*')
				{
					System.out.println(-1);
					return;
				}
			}
//			System.out.println();
		}
		if(ans.isEmpty()) System.out.println(-1);
		else
		{
			System.out.println(ans.size());
			while(!ans.isEmpty())
				System.out.println(ans.poll());
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}