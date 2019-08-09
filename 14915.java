import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int[][] dp = new int[N+1][10];
		
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 0; j <= 9; j++)
				dp[i][j] += dp[i-1][j];
			if(i < 10)
				dp[i][i] += 1;
			else
			{
				int n = i;
				while(true)
				{
					int mod = n % 10;
					dp[i][mod] += 1;
					n /= 10;
					if(n < 10)
					{
						dp[i][n] += 1;
						break;
					}
				}
			}
		}
		
//		for(int i = 1; i <= N; i++)
//		{
//			for(int j = 0; j <= 9; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
		
		System.out.println(dp[N][d]);
	}
}