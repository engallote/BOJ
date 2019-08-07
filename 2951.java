import java.util.*;

public class Main {
	static int len;
	static int[][] dp;
	static char[] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.next().toCharArray();
		len = c.length;
		dp = new int[len][35];
		for(int i = 0; i < len; i++)
			Arrays.fill(dp[i], -1);
		
		int res = solve("", 0, 0);
		System.out.println(res);
	}
	private static int solve(String str, int idx, int pre) {
		if(idx >= len) return 1;
		if(dp[idx][pre] != -1) return dp[idx][pre];
		int ret = 0;
		if(c[idx] != '0')
		{
			ret += solve(str + "," + c[idx], idx + 1, c[idx]-'0');
			if(idx + 1 < len && Integer.parseInt(c[idx]+""+c[idx+1]) <= 34)
				ret += solve(str + "," + c[idx] + "" + c[idx+1], idx + 2, Integer.parseInt(c[idx]+""+c[idx+1]));
		}
		return dp[idx][pre] = ret;
	}
}