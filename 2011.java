import java.util.*;

public class Main {
	static int len;
	static final int mod = 1000000;
	static long[][] dp;
	static char[] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.next().toCharArray();
		len = c.length;
		dp = new long[len][27];
		
		for(int i = 0; i < len; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solve(0, 0) % mod);
	}
	private static long solve(int idx, int pre) {
		if(idx >= len) return 1;
		if(dp[idx][pre] != -1) return dp[idx][pre] % mod;
		long ret = 0;
		
		if(c[idx] != '0' && idx + 1 < len && Integer.parseInt(new String(c[idx] + "" + c[idx+1])) <= 26)//두 자리 숫자
			ret += (solve(idx + 2, Integer.parseInt(new String(c[idx] + "" + c[idx+1])))) % mod;
		if(c[idx] > '0')
			ret += (solve(idx + 1, c[idx]-'0')) % mod;
		return dp[idx][pre] = ret;
	}
}