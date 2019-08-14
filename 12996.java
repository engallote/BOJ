import java.util.*;

public class Main {
	static int N, mod = 1000000007;
	static long[][][][] dp = new long[51][51][51][51];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		for(int i = 0; i <= 50; i++)
			for(int j = 0; j <= 50; j++)
				for(int k = 0; k <= 50; k++)
					Arrays.fill(dp[i][j][k], -1);
		
		long res = solve(0, a, b, c);
		System.out.println(res);
	}
	private static long solve(int cnt, int a, int b, int c) {
		if(cnt == N) 
		{
			if(a == 0 && b == 0 && c == 0) return 1;
			else return 0;
		}
		if(dp[cnt][a][b][c] != -1) return dp[cnt][a][b][c] % mod;
//		System.out.println(cnt + " : " + a + " " + b + " " + c);
		long ret = 0;
		if(a > 0)
			ret += solve(cnt + 1, a - 1, b, c) % mod;
		if(b > 0)
			ret += solve(cnt + 1, a, b - 1, c) % mod;
		if(c > 0)
			ret += solve(cnt + 1, a, b, c - 1) % mod;
		
		if(a > 0 && b > 0)
			ret += solve(cnt + 1, a - 1, b - 1, c) % mod;
		if(a > 0 && c > 0)
			ret += solve(cnt + 1, a - 1, b, c - 1) % mod;
		if(b > 0 && c > 0)
			ret += solve(cnt + 1, a, b - 1, c - 1) % mod;
		if(a > 0 && b > 0 && c > 0)
			ret += solve(cnt + 1, a - 1, b - 1, c - 1) % mod;
		
		return dp[cnt][a][b][c] = ret % mod;
	}
}