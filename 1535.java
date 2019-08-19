import java.util.*;

public class Main {
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] m = new int[N], p = new int[N];
		
		for(int i = 0; i < N; i++)
			m[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			p[i] = sc.nextInt();
		
		solve(0, 100, 0, m, p, N);
		System.out.println(res);
	}

	private static void solve(int idx, int hp, int sum, int[] m, int[] p, int until) {
		if(idx == until)
		{
			res = Math.max(res, sum);
			return;
		}
		
		if(hp - m[idx] > 0)
			solve(idx + 1, hp - m[idx], sum + p[idx], m, p, until);
		solve(idx + 1, hp, sum, m, p, until);
	}
}