import java.util.*;

public class Main {
	static int N, M, res = Integer.MAX_VALUE;
	static int[] d, c;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		d = new int[N];
		c = new int[M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(dp[i], -1);
			d[i] = sc.nextInt();
		}
		
		for(int i = 0; i < M; i++)
			c[i] = sc.nextInt();
		
		System.out.println(dfs(0, 0));
	}
	private static int dfs(int didx, int cidx) {
		if(didx == N)
		{
			return 0;
		}
		if(cidx >= M) return 1000000000;
		if(dp[didx][cidx] != -1) return dp[didx][cidx];
		
		int ret = 0;
		ret = dfs(didx + 1, cidx + 1) + (d[didx] * c[cidx]);
		ret = Math.min(ret, dfs(didx, cidx + 1));
		return dp[didx][cidx] = ret;
	}
}