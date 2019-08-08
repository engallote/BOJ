import java.util.*;

public class Main {
	static int N, M, res, cnt;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int Q = sc.nextInt();
		chk = new boolean[N][M];
		arr = new int[N][M];
		for(int k = 0; k < Q; k++)
		{
			int num = sc.nextInt();
			int x = sc.nextInt();
			
			if(num == 0)//가로 자르기
				hor(x);
			else//세로 자르기
				ver(x);
		}
		
		res = 0;
		cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(!chk[i][j])
				{
					cnt = 0;
					dfs(i, j);
					res = Math.max(res, cnt);
				}
		System.out.println(res);
	}
	private static void dfs(int x, int y) {
		cnt++;
		chk[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != arr[x][y] || chk[nx][ny])
				continue;
			dfs(nx, ny);
		}
		
	}
	private static void hor(int x) {
		for(int i = 0; i < x; i++)
			for(int j = 0; j < M; j++)
				arr[i][j]++;
	}
	private static void ver(int x) {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < x; j++)
				arr[i][j]++;
		for(int i = 0; i < N; i++)
			for(int j = x; j < M; j++)
				arr[i][j]+=10000;
	}
}