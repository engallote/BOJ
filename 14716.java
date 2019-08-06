import java.util.*;

public class Main {
	static int[] dx = {1,0,-1,0,1,1,-1,-1}, dy = {0,1,0,-1,1,-1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		boolean[][] chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		int res = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 1 && !chk[i][j])
				{
					res++;
					dfs(i, j, N, M, arr, chk);
				}
				
		System.out.println(res);
	}

	private static void dfs(int x, int y, int n, int m, int[][] arr, boolean[][] chk) {
		chk[x][y] = true;
		
		for(int i = 0; i < 8; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0 || chk[nx][ny])
				continue;
			dfs(nx, ny, n, m, arr, chk);
		}
	}
}