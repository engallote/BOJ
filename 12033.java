import java.util.*;

public class Main {
	static int N;
	static boolean end;
	static int[] arr, chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N * 2];
			chk = new int[N * 2];
			end = false;
			
			for(int i = 0; i < N * 2; i++)
				arr[i] = sc.nextInt();
		
			System.out.print("Case #" + test_case + ": ");
			solve(N * 2 - 1, 0);
			System.out.println();
		}
	}
	private static void solve(int idx, int cnt) {
		if(end) return;
		if(cnt == N)
		{
			end = true;
			for(int i = 0; i < N * 2; i++)
				if(chk[i] == 2)
					System.out.print(arr[i] + " ");
			return;
		}
		if(idx == 0) return;
		if(chk[idx] != 0)
		{
			solve(idx - 1, cnt);
		}
		else
		{
			int disc = (int)(arr[idx] * 0.75);
			for(int i = idx - 1; i >= 0; i--)
				if(arr[i] == disc && chk[i] == 0)
				{
					chk[idx] = 1;
					chk[i] = 2;
					solve(idx - 1, cnt + 1);
					chk[idx] = chk[i] = 0;
				}
		}
	}
}