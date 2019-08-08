import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][2];
		dp = new int[N][M+1][K+1];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j <= M; j++)
				Arrays.fill(dp[i][j], -1);
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int m, int k) {
		if(idx == N) return 0;
		if(dp[idx][m][k] != -1) return dp[idx][m][k];
		int ret = 0;
		
		if(m + arr[idx][0] <= M && k + arr[idx][1] <= K)
			ret = solve(idx + 1, m + arr[idx][0], k + arr[idx][1]) + 1;
		ret = Math.max(ret, solve(idx + 1, m, k));
		
		return dp[idx][m][k] = ret;
	}
}