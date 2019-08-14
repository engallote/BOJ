import java.util.*;

public class Main {
	static int N, M, res = 0;
	static int[][] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new boolean[M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		solve(0, 0);
		System.out.println(res);
	}
	private static void solve(int idx, int cnt) {
		if(cnt > 3) return;
		if(cnt >= 1)
		{
			int sum = 0;
			int[] max = new int[N];
			for(int i = 0; i < M; i++)
				if(chk[i])
				{
					for(int j = 0; j < N; j++)
						max[j] = Math.max(arr[j][i], max[j]);
				}
			for(int i = 0; i < N; i++)
				sum += max[i];
			res = Math.max(res, sum);
		}
		if(idx >= M) return;
		chk[idx] = true;
		solve(idx + 1, cnt + 1);
		chk[idx] = false;
		solve(idx + 1, cnt);
	}
}