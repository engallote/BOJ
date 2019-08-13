import java.util.*;

public class Main {
	static int N;
	static boolean end = false;
	static long[] arr, res;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N];
		res = new long[N];
		chk = new boolean[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		Arrays.sort(arr);
		
		solve(0, 0);
	}
	private static void solve(long pre, int idx) {
		if(end) return;
		if(idx == N)
		{
			end = true;
			for(long i : res)
				System.out.print(i + " ");
			return;
		}
		if(idx == 0)
		{
			for(int i = 0; i < N; i++)
			{
				chk[i] = true;
				res[0] = arr[i];
				solve(arr[i], idx + 1);
				res[0] = 0;
				chk[i] = false;
			}
		}
		else
		{
			for(int i = 0; i < N; i++)
				if(!chk[i] && (pre / 3 == arr[i] || pre * 2 == arr[i]))
				{
					chk[i] = true;
					res[idx] = arr[i];
					solve(arr[i], idx + 1);
					res[idx] = 0;
					chk[i] = false;
				}
		}
	}
}