import java.util.*;

public class Main {
	static int N, S, cnt = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		solve(0, 0);
		System.out.println(cnt);
	}
	private static void solve(int idx, int sum) {
		if(idx == N) return;
		if(sum + arr[idx] == S)
			cnt++;
		
		solve(idx + 1, sum + arr[idx]);
		solve(idx + 1, sum);
	}
}