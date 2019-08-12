import java.util.*;

public class Main {
	static long[] dp = new long[36];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(dp, -1);
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		int N = sc.nextInt();
		
		for(int i = 3; i <= N; i++)
		{
			int cnt = 1;
			long sum = 0;
			for(int j = 0; j < i; j++)
			{
				sum += (dp[j] * dp[i-cnt]);
				cnt++;
			}
			dp[i] = sum;
		}
		System.out.println(dp[N]);
	}
}