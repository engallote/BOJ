import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i = 1; i <= N; i++)
			Arrays.fill(dp[i], -1);
		for(int i = 0; i < K; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.max(arr[a][b], c);
		}
		int res = dfs(1, 1);
		System.out.println(res > 0 ? res : 0);	
	}
	private static int dfs(int idx, int cnt) {
		if(idx == N) return 0;
		if(cnt == M) return Integer.MIN_VALUE;
		if(dp[idx][cnt] != -1) return dp[idx][cnt];
		
		int ret = 0;
		
		for(int i = idx + 1; i <= N; i++)
			if(arr[idx][i] > 0)
				ret = Math.max(ret, dfs(i, cnt + 1) + arr[idx][i]);
			
		return dp[idx][cnt] = ret;
	}
}