import java.util.*;

public class Main {
	static int K, N;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		dp = new long[150][N];
		
		for(int i = 0; i < 150; i++)
			Arrays.fill(dp[i], -1);
		
		long res = solve(K, 0);
		System.out.println(res);
	}
	private static long solve(int k, int cnt) {
		if(k <= 0) return 0;
		if(cnt >= N) return 1;
		if(dp[k][cnt] != -1) return dp[k][cnt];
		
		long ret = solve(k + 1, cnt + 1);
		ret += solve(k - 1, cnt + 1);
		return dp[k][cnt] = ret;
	}
}