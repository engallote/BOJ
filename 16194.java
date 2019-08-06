import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N+1][N+1];
		arr = new int[N+1];
		Arrays.fill(dp[0], -1);
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		long res = solve(0, 0);
		System.out.println(res);
	}
	private static long solve(int idx, int cnt) {
		if(cnt == N) return 0;
		if(dp[idx][cnt] != -1) return dp[idx][cnt];
		
		long ret = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
			if(cnt + i <= N)
				ret = Math.min(ret, solve(i, cnt + i) + arr[i]);
		
		return dp[idx][cnt] = ret;
	}
}