import java.util.*;

public class Main {
	static int N;
	static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
	static int[] arr, op = new int[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < 4; i++)
			op[i] = sc.nextInt();
		
		solve(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void solve(int idx, long sum) {
		if(idx == N)
		{
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			if(op[i] > 0)
			{
				op[i]--;
				if(i == 0)
					solve(idx+1, sum + arr[idx]);
				else if(i == 1)
					solve(idx+1, sum - arr[idx]);
				else if(i == 2)
					solve(idx+1, sum * arr[idx]);
				else
					solve(idx+1, sum / arr[idx]);
				op[i]++;
			}
		}
	}
}