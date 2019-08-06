import java.util.*;

public class Main {
	static long mod = 1000000007;
	static int N, M;
	static long[][] dp = new long[10001][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i = 0; i <= 10000; i++) Arrays.fill(dp[i], -1);
		
		long res = solve(0, 0) % mod;
		System.out.println(res);
	}
	private static long solve(int idx, int w) {
		if(idx == N) return 1;
		if(dp[idx][w] != -1) return dp[idx][w] % mod;
		long ret = solve(idx + 1, 0) % mod;
		if(idx + M <= N) ret += solve(idx + M, 1) % mod;
		return dp[idx][w] = ret % mod;
	}
}