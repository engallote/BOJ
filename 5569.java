import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int[][] dp;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        dp = new int[K][1<<N];
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        for(int i = 0; i < K; i++)
        	Arrays.fill(dp[i], -1);
        solve(0, 0, "");
        System.out.println(hs.size());
	}
	private static int solve(int cnt, int chk, String num) {
		if(cnt == K)
		{
			hs.add(num);
			return 1;
		}
		
		int ret = 0;
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
				ret += solve(cnt + 1, chk|(1<<i), num + Integer.toString(arr[i]));
		
		return ret;
	}
}