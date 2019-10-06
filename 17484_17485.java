import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][][] chk, dp;
	static int[] dx = {1, 1, 1}, dy = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		chk = new int[N][M][4];
		dp = new int[N][M][4];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
				Arrays.fill(dp[i][j], -1);
				if(i == 0) Arrays.fill(chk[i][j], num);
			}
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++)
			res = Math.min(res, solve(0, i, 3) + arr[0][i]);
		System.out.println(res);
	}
	private static int solve(int x, int y, int d) {
		if(x == N - 1) return 0;
		if(dp[x][y][d] != -1) return dp[x][y][d];
		int ret = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++)
			if(d != i)
			{
				int nx = x + dx[i], ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny][i] < chk[x][y][d] + arr[nx][ny])
					continue;
				ret = Math.min(ret, solve(nx, ny, i) + arr[nx][ny]);
			}
		return dp[x][y][d] = ret;
	}
}