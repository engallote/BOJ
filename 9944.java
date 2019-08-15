import java.util.*;

public class Main {
	static int N, M, res, all;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(sc.hasNext())
		{
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			chk = new boolean[N][M];
			all = N * M;
			res = Integer.MAX_VALUE;
			int x = -1, y = 0;
			for(int i = 0; i < N; i++)
			{
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < M; j++)
					if(arr[i][j] == '*') all--;
			}
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] == '.')
					{
						solve(i, j, 0, 1, 1);
						solve(i, j, 1, 1, 1);
						solve(i, j, 2, 1, 1);
						solve(i, j, 3, 1, 1);
					}
			if(res == Integer.MAX_VALUE) res = -1;
			if(all == 1) res = 0;
			System.out.println("Case " + tc + ": " + res);
			tc++;
		}
	}
	private static void solve(int x, int y, int d, int cnt, int v) {
		if(v >= all) 
		{
			res = Math.min(res, cnt);
			return;
		}
		chk[x][y] = true;
		int nx = x + dx[d], ny = y + dy[d];
		
		if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '*' ||  chk[nx][ny])
		{
			for(int i = 0; i < 4; i++)
			{
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '*' || chk[nx][ny]) 
					continue;
				solve(nx, ny, i, cnt + 1, v + 1);
			}
		}
		else solve(nx, ny, d, cnt, v + 1);
		chk[x][y] = false;
	}
}