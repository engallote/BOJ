import java.util.*;

public class Main {
	static int N, M, cnt;
	static char[][] c;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M  = sc.nextInt();
		N = sc.nextInt();
		c = new char[N][M];
		chk = new boolean[N][M];
		long b = 0, w = 0;
		
		for(int i = 0; i < N; i++)
			c[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(!chk[i][j])
				{
					cnt = 0;
					dfs(i, j);
					if(c[i][j] == 'B') b += (long)Math.pow(cnt, 2);
					else w += (long)Math.pow(cnt, 2);
				}
		
		System.out.println(w + " " + b);
	}
	private static void dfs(int x, int y) {
		chk[x][y] = true;
		cnt++;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || c[nx][ny] != c[x][y] || chk[nx][ny])
				continue;
			dfs(nx, ny);
		}
	}
}