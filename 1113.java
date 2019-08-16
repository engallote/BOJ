import java.util.*;

public class Main {
	static int N, M, res;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[][] chk;
	static Queue<Pair> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		res = 0;
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				arr[i][j] = c[j] - '0';
		}
		
		for(int k = 1; k < 9; k++)
		{
			chk = new boolean[N][M];
			for(int i = 1; i < N - 1; i++)
				for(int j = 1; j < M - 1; j++)
				{
					if(arr[i][j] != k || chk[i][j]) continue;
					q = new LinkedList<>();
					q.add(new Pair(i, j));
					bfs(k);
				}
		}
		System.out.println(res);
	}
	private static void bfs(int k) {
		Queue<Pair> tmp = new LinkedList<>();
		tmp.add(q.peek());
		boolean end = false;
		while(!tmp.isEmpty())
		{
			Pair p = tmp.poll();
			chk[p.x][p.y] = true;
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] != k) continue;
				if(nx == 0 || ny == 0 || nx == N - 1 || ny == M - 1) end = true;
				chk[nx][ny] = true;
				tmp.add(new Pair(nx, ny));
				q.add(new Pair(nx, ny));
			}
		}
		
		if(end) return;
		tmp.clear();
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			tmp.add(p);
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				min = Math.min(min, arr[nx][ny]);
			}
		}
		
		if(min > k)
		{
			while(!tmp.isEmpty())
			{
				Pair p = tmp.poll();
				
				res += min - arr[p.x][p.y];
				arr[p.x][p.y] = min;
			}
		}
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