import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		dp = new int[N][M];
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			Arrays.fill(dp[i], -1);
		}

		int res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				int d = 0;
				if(arr[i][j] == 'D') d = 1;
				else if(arr[i][j] == 'U') d = 2;
				else if(arr[i][j] == 'R') d = 3;
				else d = 4;
				res += solve(i, j, d);
			}
			
		System.out.println(res);
	}
	private static int solve(int x, int y, int d) {
		if(x < 0 || y < 0 || x >= N || y >= M) return 1;
		if(dp[x][y] != -1) return dp[x][y];
//		System.out.println(x + " " + y + " " + d);
		dp[x][y] = 0;
		int ret = 0;
		if(arr[x][y] == 'D') ret += solve(x + 1, y, 1); 
		else if(arr[x][y] == 'U') ret += solve(x - 1, y, 2);
		else if(arr[x][y] == 'R') ret += solve(x, y + 1, 3);
		else if(arr[x][y] == 'L') ret += solve(x, y - 1, 4);
		
		
		return dp[x][y] = ret;
	}
}