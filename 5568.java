import java.util.*;

public class Main {
	static int N, M;
	static final int mod = 100000;
	static int[][][][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N][M][2][2];
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		for(int k = 0; k < 2; k++)
        			Arrays.fill(dp[i][j][k], -1);
        int res = solve(0, 0, 0, false);
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		for(int k = 0; k < 2; k++)
        			Arrays.fill(dp[i][j][k], -1);
        res += solve(0, 0, 1, false);
        System.out.println(res%mod);
	}
	private static int solve(int x, int y, int d, boolean turn) {
		if(x == N - 1 && y == M - 1) return 1;
		if(dp[x][y][d][turn ? 1 : 0] != -1) return dp[x][y][d][turn ? 1 : 0];
		int ret = 0;
//		System.out.println(x + " " + y + " " + turn);
		for(int i = 0; i < 2; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(i == d)//한 번 더 직진
				ret += solve(nx, ny, i, true) % mod;
			else if(turn)//교차로에서 회전 가능
				ret += solve(nx, ny, i, false) % mod;
		}
		
		return dp[x][y][d][turn ? 1 : 0] = ret;
	}
}