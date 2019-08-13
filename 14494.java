import java.util.*;

public class Main {
	static int N, M, mod = 1000000007;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dp = new long[N][M];
		for(int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);
		
		long res = solve(0, 0) % mod;
		System.out.println(res);
	}
	private static long solve(int x, int y) {
		if(x == N - 1 && y == M - 1) return 1;
		if(dp[x][y] != -1) return dp[x][y] % mod;
		
		long ret = 0;
		if(x + 1 < N) ret += solve(x + 1, y) % mod;
		if(y + 1 < M) ret += solve(x, y + 1) % mod;
		if(x + 1 < N && y + 1 < M) ret += solve(x + 1, y + 1) % mod;
		
		return dp[x][y] = ret;
	}
}