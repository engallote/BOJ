import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		map = new int[N][M];
		chk = new boolean[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > 0) q.add(new Pair(i, j, arr[i][j]));
			}
		
		Queue<Pair> alive = new LinkedList<>(), melt = new LinkedList<>();
		int res = 0;
		while(true)
		{
			int cnt = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] > 0 && !chk[i][j])
					{
						dfs(i, j);
						cnt++;
					}
						
			if(cnt >= 2) break;
			if(cnt == 0)
			{
				res = 0;
				break;
			}
			//find
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				
				int m = 0;
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] > 0) continue;
					m++;
				}
				map[p.x][p.y] = m;
				if(m >= p.cnt)
					melt.add(p);
				else
					alive.add(p);
			}
			
			while(!melt.isEmpty())
			{
				Pair p = melt.poll();
				arr[p.x][p.y] = 0;
				map[p.x][p.y] = 0;
			}
			
			while(!alive.isEmpty())
			{
				Pair p = alive.poll();
				q.add(new Pair(p.x, p.y, p.cnt - map[p.x][p.y]));
				map[p.x][p.y] = 0;
			}
			
			for(int i = 0; i < N; i++)
				Arrays.fill(chk[i], false);
			res++;
		}
		System.out.println(res);
	}
	private static void dfs(int x, int y) {
		chk[x][y] = true;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == 0) continue;
			dfs(nx, ny);
		}
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}