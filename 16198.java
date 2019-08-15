import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N][1<<N+1];
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(0, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int chk) {
		if(idx >= N - 2) return 0;
		if(dp[idx][chk] != -1) return dp[idx][chk];
		int ret = 0;
		
		for(int i = 1; i < N-1; i++)
			if((chk&(1<<i)) == 0)
			{
				int a = 0, b = 0;
				for(int j = i - 1; j >= 0; j--)
					if((chk&(1<<j)) == 0)
					{
						a = arr[j];
						break;
					}
				for(int j = i + 1; j < N; j++)
					if((chk&(1<<j)) == 0)
					{
						b = arr[j];
						break;
					}
				
				ret = Math.max(ret, solve(idx + 1, chk|(1<<i)) + (a * b));
			}
		return dp[idx][chk] = ret;
	}
}