import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		dp = new int[N+1][3];
		Arrays.fill(dp[0], -1);
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(dp[i], -1);
			arr[i] = sc.nextInt();
		}
		
		int res = solve(0, 2);
		System.out.println(res);
	}
	private static int solve(int idx, int milk) {
		if(idx > N) return 0;
		if(dp[idx][milk] != -1) return dp[idx][milk];
//		System.out.println(idx + " " + milk);
		int ret = 0;
		
		for(int i = idx + 1; i <= N; i++)
			if((milk + 1) % 3 == arr[i])
				ret = Math.max(ret, solve(i, arr[i]) + 1);
		
		return dp[idx][milk] = ret;
	}
}