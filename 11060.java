import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int INF = 10000000;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i; j <= i + arr[i] && j < N; j++)
				dp[j] = Math.min(dp[j], dp[i] + 1);
		}
		
		System.out.println(dp[N-1] == INF ? -1 : dp[N-1]);
	}
}