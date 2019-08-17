import java.util.*;

public class Main {
	static int N;
	static int[] coins;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			N = sc.nextInt();
			coins = new int[N];
			dp = new int[20][10001];
			for(int i = 0; i < N; i++)
				coins[i] = sc.nextInt();
			
			int M = sc.nextInt();
			for(int i = 0; i < 20; i++)
				Arrays.fill(dp[i], -1);
			
			int res = solve(0, M);
			System.out.println(res);
		}
	}
	private static int solve(int idx, int m) {
		if(m == 0) return 1;
		if(dp[idx][m] != -1) return dp[idx][m];
		int ret = 0;
		
		for(int i = idx; i < N; i++)
			if(m - coins[i] >= 0)
				ret += solve(i, m - coins[i]);
		
		return dp[idx][m] = ret;
	}
}