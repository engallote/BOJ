import java.util.*;

public class Main {
	static int N, M, C;
	static int[] arr;
	static int[][][] dp = new int[1<<13][11][21];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < (1<<13); i++)
			for(int j = 0; j <= M; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int sum, int chk) {
		if(idx == M) return 0;
		if(dp[chk][idx][sum] != -1) return dp[chk][idx][sum];
		
		int ret = 0;
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
			{
				if(sum + arr[i] <= C)
					ret = Math.max(ret, solve(idx, sum + arr[i], chk | (1<<i)) + 1);
				ret = Math.max(ret, solve(idx + 1, 0, chk));
			}
		return dp[chk][idx][sum] = ret;
	}
}