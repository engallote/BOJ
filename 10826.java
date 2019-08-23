import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		long[] dp = new long[10001];
		BigInteger[] dp = new BigInteger[10001];
		Arrays.fill(dp, BigInteger.ZERO);
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;
		
		for(int i = 3; i <= N; i++)
			dp[i] = dp[i].add(dp[i-2].add(dp[i-1]));
		
		System.out.println(dp[N]);
	}
}