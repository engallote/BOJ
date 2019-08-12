import java.util.*;

public class Main {
	static final int mod = 1000000007;
	static int[] dp = new int[51];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = solve(N);
		System.out.println(res);
	}
	private static int solve(int n) {
		if(n < 2) return 1;
		if(dp[n] != 0) return dp[n] % mod;
		int ret = (solve(n - 2) + solve(n - 1) + 1) % mod;
		return dp[n] = ret;
	}
}