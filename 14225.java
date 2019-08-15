import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	static int[] num = new int[3000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N][1<<N+1];
		
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(dp[i], -1);
			arr[i] = sc.nextInt();
			num[arr[i]]++;
		}
		solve(0, 0);
		for(int i = 1; i <= 2000000; i++)
			if(num[i] == 0)
			{
				System.out.println(i);
				break;
			}
	}
	private static int solve(int idx, int chk) {
		if(idx >= N) return 0;
		if(dp[idx][chk] != -1) return dp[idx][chk];
		
		int ret = 0;
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
			{
				ret = solve(idx, chk|(1<<i)) + arr[i];
				num[ret]++;
			}
		return dp[idx][chk] = ret;
	}
}