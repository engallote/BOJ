import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] res = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			
			int l = 0, r = N - 1, idx = 0;
			while(l <= r && idx < N)
			{
				res[l] = arr[idx];
				idx += 1;
				if(idx == N) break;
				res[r] = arr[idx];
				idx += 1;
				l++;
				r--;
			}
			int ans = Math.abs(res[N-1] - res[0]);
			for(int i = 0; i < N-1; i++)
				ans = Math.max(ans, Math.abs(res[i+1] - res[i]));
			System.out.println(ans);
		}
	}
}