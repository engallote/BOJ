import java.util.*;

public class Main {
	static int N;
	static int[] dp = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Arrays.fill(dp, -1);
		
		int res = solve(0);
		System.out.println(res);
	}
	private static int solve(int n) {
		if(n > N) return 1000000;
		if(n == N) return 0;
		if(dp[n] != -1) return dp[n];
		
		int ret = solve(n + 7) + 1;
		ret = Math.min(ret, solve(n + 5) + 1);
		ret = Math.min(ret, solve(n + 2) + 1);
		ret = Math.min(ret, N - n);
		return dp[n] = ret;
	}
}