import java.util.*;

public class Main {
	static int N;
	static long mod = 1000000009;
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[40000];
		
		dp[1] = 0;
		dp[2] = 2;
		dp[3] = 6;
		dp[4] = 18;
		
		for(int i = 5; i <= N; i++)
			dp[i] = (dp[i - 1] * 3) % mod;
		System.out.println(dp[N]);
	}
}