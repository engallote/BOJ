import java.util.*;

public class Main {
	static int N, mod = 1234567;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			dp = new int[N][11];
			
			for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
			int res = solve(0, 10) % mod;
			System.out.println(res);
		}
	}
	private static int solve(int idx, int num) {
		if(idx == N) return 1;
		if(dp[idx][num] != -1) return dp[idx][num] % mod;
		int ret = 0;
		
		for(int i = 0; i < 10; i++)
		{
			if(num == 10)//첫 시작
				ret = (ret + solve(idx + 1, i)) % mod;
			else
			{
				if(num == 0 && i == 7)
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 1 && ( i == 2 || i == 4))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 2 && (i == 1 || i == 3 || i == 5))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 3 && (i == 2 || i == 6))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 4 && (i == 1 || i == 5 || i == 7))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 5 && (i == 2 || i == 4 ||i == 6 || i == 8))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 6 && (i == 3 || i == 5 || i == 9))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 7 && (i == 4 || i == 8 || i == 0))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 8 && (i == 5 || i == 7 || i == 9))
					ret = (ret + solve(idx + 1, i)) % mod;
				else if(num == 9 && (i == 6 || i == 8))
					ret = (ret + solve(idx + 1, i)) % mod;
			}
		}
		
		return dp[idx][num] = ret % mod;
	}
}