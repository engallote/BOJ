import java.util.*;

public class Main {
	static int N;
	static long res = 0;
	static final int mod = 1000000000;
	static long[][] dp = new long[1000001][21];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        res = solve(N, 20) % mod;
        System.out.println(res);
    }
	private static long solve(int cur, int cnt) {
		if(cur == 0) return 1;
		if(cur < 0) return 0;
		if(dp[cur][cnt] > 0) return dp[cur][cnt];
		
		for(int i = cnt; i >= 0; i--)
		{
			if(cur - (int)Math.pow(2, i) >= 0)
			{
				dp[cur][cnt] += solve(cur - (int)Math.pow(2, i), i);
				dp[cur][cnt] %= mod;
			}
		}
		
		return dp[cur][cnt] % mod;
	}
}