import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] dp = new int[N+1], parent = new int[N+1], index = new int[N+1];
			int[] arr = new int[N+1];
			
			for(int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();
			
			int idx = 1;
			Arrays.fill(parent, -1);
			dp[1] = arr[1];
			index[1] = 1;
			
			for(int i = 2; i <= N; i++)
			{
				if(dp[idx] < arr[i])
				{
					dp[++idx] = arr[i];
					parent[i] = index[idx-1];
					index[idx] = i;
				}
				else
				{
					int l = 1, r = idx, mid;
					while(l < r)
					{
						mid = (l + r) / 2;
						if(dp[mid] >= arr[i]) r = mid;
						else l = mid + 1;
					}
					dp[r] = arr[i];
					if(r > 1) parent[i] = index[r-1];
					index[r] = i;
				}
			}
			System.out.println("Case #" + test_case);
			if(idx >= K)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}