import java.util.*;

public class Main {
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			dp = new int[101][101][101];
			for(int i = 0; i <= 100; i++)
				for(int j = 0; j <= 100; j++)
					Arrays.fill(dp[i][j], -1);
			int res = solve(N, M, K);
			System.out.println(res);
		}
	}
	private static int solve(int n, int m, int k) {
		if(Math.abs(n - m) == 1 && Math.abs(k - m) == 1) return 0;
		if(dp[n][m][k] != -1) return dp[n][m][k];
		
		int ret = 0;
		if(m - n > 1) ret = Math.max(ret, solve(n, n + 1, m) + 1);
		if(k - m > 1) ret = Math.max(ret, solve(m, m + 1, k) + 1);
		return dp[n][m][k] = ret;
	}
}