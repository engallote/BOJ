import java.util.*;

public class Main {
	static int N, cnt = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		long[][] dp = new long[N][21];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		dp[0][arr[0]] = 1;
		
		for(int i = 1; i < N - 1; i++)
		{
			for(int j = 0; j <= 20; j++)
				if(dp[i-1][j] > 0)
				{
					if(j + arr[i] <= 20)
						dp[i][j + arr[i]] += dp[i-1][j];
					if(j - arr[i] >= 0)
						dp[i][j - arr[i]] += dp[i-1][j];
				}
		}
		
		System.out.println(dp[N-2][arr[N-1]]);
	}
}