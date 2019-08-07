import java.util.*;

public class Main {
	static int N, K, mod = 10000;
	static int[] arr;
	static long[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N+1];
		dp = new long[N+1][4][4];
		
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < K; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a] = b;
		}
		
		for(int i = 0; i <= N; i++)
			for(int j = 0; j < 4; j++)
				Arrays.fill(dp[i][j], -1);
		
		long res = solve(1, 0, 0);
		System.out.println(res);
	}
	private static long solve(int idx, int cur, int pre) {
		if(idx > N) return 1;
		if(dp[idx][cur][pre] != -1) return dp[idx][cur][pre] % mod;
		long ret = 0;
//		System.out.println(idx + " " + cur + " " + pre);
		if(arr[idx] != -1)
		{
			if(arr[idx] == cur && cur == pre) return 0;//3일 연속
			ret += solve(idx + 1, arr[idx], cur) % mod;
		}
		else
		{
			for(int i = 1; i <= 3; i++)
				if((pre == cur && cur != i) || pre != cur)
					ret += solve(idx + 1, i, cur) % mod;
		}
		
		return dp[idx][cur][pre] = ret % mod;
	}
}