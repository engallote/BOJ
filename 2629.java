import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N+1][40001];
		
		for(int i = 0; i <= N; i++)
			Arrays.fill(dp[i], -1);
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		solve(0, 0);
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			System.out.println(dp[N][num] == 1 ? "Y" : "N");
		}
	}
	private static void solve(int idx, int sum) {
		if(dp[idx][sum] != -1) return;
		dp[idx][sum] = 1;
		if(idx == N) return;
		
		solve(idx + 1, sum + arr[idx]);
		solve(idx + 1, sum);
		solve(idx + 1, Math.abs(sum - arr[idx]));
	}
}