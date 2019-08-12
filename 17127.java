import java.util.*;

public class Main {
	static int N, res;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		res = 0;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		solve(0, 0, 1, 0);
		System.out.println(res);
	}
	private static void solve(int idx, int aidx, int num, int sum) {
		if(idx == 4)
		{
			res = Math.max(res, sum);
			return;
		}
		if(aidx == N) return;
		
		solve(idx, aidx + 1, num * arr[aidx], sum);
		solve(idx + 1, aidx + 1, 1, sum + (num * arr[aidx]));
	}
}