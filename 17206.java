import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[80001];
		
		for(int i = 1; i <= 80000; i++)
		{
			if(i % 3 == 0 || i % 7 == 0)
				dp[i] += i;
			dp[i] += dp[i-1];
		}
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
	}
}