import java.util.*;

public class Main {
	static int N, max = 0, cnt = 0;
	static int[][] arr, dp;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				max = Math.max(max, dfs(i, j));
		
		for(int i =0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		System.out.println(max);
	}
	private static int dfs(int x, int y) {
		if(dp[x][y] > 0) return dp[x][y];
		dp[x][y] = 1;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(arr[x][y] < arr[nx][ny])
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
		}
		return dp[x][y];
	}
}