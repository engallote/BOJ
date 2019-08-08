import java.util.*;

public class Main {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr, op;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		op = new int[4];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < 4; i++)
			op[i] = sc.nextInt();
		
		solve(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void solve(int idx, int sum) {
		if(idx == N)
		{
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++)
		{
			if(op[i] > 0)
			{
				op[i]--;
				if(i == 0) solve(idx + 1, sum + arr[idx]);
				else if(i == 1) solve(idx + 1, sum - arr[idx]);
				else if(i == 2) solve(idx + 1, sum * arr[idx]);
				else
				{
					int num = Math.abs(sum) / arr[idx];
					if(sum < 0) solve(idx + 1, -num);
					else solve(idx + 1, num);
				}
				op[i]++;
			}
		}
	}
}