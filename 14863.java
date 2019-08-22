import java.util.*;

public class Main {
	static int N, K, max = 0;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[][] travel = new int[N][4];
		dp = new int[100001][N];
		
		for(int i = 0; i < N; i++)
		{
			travel[i][0] = sc.nextInt();//시간
			travel[i][1] = sc.nextInt();//모금액
			
			travel[i][2] = sc.nextInt();
			travel[i][3] = sc.nextInt();
		}
		
        for(int i = 0; i <= 100000; i++) 
        	Arrays.fill(dp[i], -1);
        
		long ans = solve(0, 0, travel);
        
        System.out.println(ans);
	}
    private static int solve(int idx, int time, int[][] travel) {
		if(time > K) return Integer.MIN_VALUE;
		if(idx >= N) return 0;
		if(dp[time][idx] != -1) return dp[time][idx];
		
		int ret = Integer.MIN_VALUE;
		ret = Math.max(ret, solve(idx + 1, time + travel[idx][0], travel) + travel[idx][1]);
		ret = Math.max(ret, solve(idx + 1, time + travel[idx][2], travel) + travel[idx][3]);
		
		return dp[time][idx] = ret;
	}
}