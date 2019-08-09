import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			
			int[][] arr = new int[N][3];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < 3; j++)
					arr[i][j] = sc.nextInt();
			
			long[][] dp = new long[N][3];
			
			for(int i = 0; i < N; i++)
				Arrays.fill(dp[i], 1000000000);
			
			dp[0][1] = arr[0][1];
			dp[0][2] = arr[0][1] + arr[0][2];
			
			for(int i = 1; i < N; i++)
			{
				dp[i][0] = Math.min(dp[i][0], Math.min(dp[i-1][0] + arr[i][0], dp[i-1][1] + arr[i][0]));
				long min1 = Math.min(dp[i][0] + arr[i][1], Math.min(dp[i-1][0] + arr[i][1], dp[i][1]));
				long min2 = Math.min(dp[i-1][1] + arr[i][1], dp[i-1][2] + arr[i][1]);
				dp[i][1] = Math.min(min1, min2);
				min1 = Math.min(dp[i][2], dp[i-1][2] + arr[i][2]);
				min2 = Math.min(dp[i][1] + arr[i][2], dp[i-1][1] + arr[i][2]);
				dp[i][2] = Math.min(min1, min2);
			}
			System.out.println(cnt + ". " + dp[N-1][1]);
			cnt++;
		}
	}
}