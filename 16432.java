import java.util.*;

public class Main {
	static int N;
	static boolean flag = false;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][10];
		dp = new int[N][10][10];
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			for(int j = 0; j < num; j++)
				arr[i][j] = sc.nextInt();
			for(int j = 0; j < 10; j++) Arrays.fill(dp[i][j], -1);
		}
		ArrayList<Integer> path = new ArrayList<>();
		solve(0, 0, 0, path);
		if(!flag) System.out.println(-1);
	}
	private static void solve(int idx, int cur, int pre, ArrayList<Integer> path) {
		if(flag) return;
		if(idx == N)
		{
			flag = true;
			for(int i : path)
				System.out.println(i);
			return;
		}
		if(dp[idx][cur][pre] != -1) return;
		
		for(int i = 0; i < 10; i++)
			if(arr[idx][i] != 0 && arr[idx][i] != cur)
			{
				path.add(arr[idx][i]);
				solve(idx + 1, arr[idx][i], cur, path);
				path.remove(path.size()-1);
			}
		dp[idx][cur][pre] = 0;
	}
}