import java.util.Scanner;

public class Main {
	static boolean[][] map = new boolean[51][51];
	static boolean[][] isVisited = new boolean[51][51];
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();

			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
				{
					isVisited[i][j] = false;
					map[i][j] = false;
				}
					
			int cnt = 0;
			for(int i = 0; i < k; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[b][a] = true;
			}
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(!isVisited[i][j] && map[i][j])
					{
						dfs(i, j);
						cnt++;
					}
			System.out.println(cnt);
		}
	}
	public static void dfs(int x, int y)
	{
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisited[nx][ny] && map[nx][ny])
			{
				isVisited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}