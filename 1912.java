import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		if(N == 1)
		{
			System.out.println(arr[0]);
			return;
		}
		long[] dp = new long[N];
		Arrays.fill(dp, -10000);
		long max = arr[0];
		dp[0] = arr[0];
		
		for(int i = 1; i < N; i++)
		{
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			if(dp[i] > max)
				max = dp[i];
		}
		
		
		System.out.println(max);
	}
}