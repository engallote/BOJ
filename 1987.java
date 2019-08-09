import java.util.*;

public class Main {
	static int R, C, res = 0;
	static char[][] arr;
	static boolean[] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visit = new boolean[26];
		
		for(int i = 0; i < R; i++)
			arr[i] = sc.next().toCharArray();
		
		
		dfs(0, 0, 1);
		System.out.println(res);
	}
	private static void dfs(int x, int y, int cnt) {
		visit[arr[x][y] - 'A'] = true;
		res = Math.max(res, cnt);
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || visit[arr[nx][ny] - 'A']) continue;
			dfs(nx, ny, cnt + 1);
		}
		visit[arr[x][y] - 'A'] = false;
	}
}