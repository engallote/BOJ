import java.util.*;

public class Main {
	static int N, INF = 100000000;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] map, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(true)
		{
			N = sc.nextInt();
			if(N == 0) break;
			map = new int[N][N];
			dp = new int[N][N];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();
					dp[i][j] = INF;
				}
			
			dp[0][0] = map[0][0];
			dfs(0, 0);
			System.out.println("Problem " + cnt + ": " + dp[N-1][N-1]);
			cnt++;
		}
	}
	private static void dfs(int x, int y) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(x, y, dp[x][y]));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
//			if(dp[p.x][p.y] < p.cost) continue;
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(dp[nx][ny] > dp[p.x][p.y] + map[nx][ny])
				{
					dp[nx][ny] = dp[p.x][p.y] + map[nx][ny];	
					pq.add(new Pair(nx, ny, dp[nx][ny]));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cost;
	Pair(int x, int y, int cost)
	{
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost >= this.cost ? -1 : 1;
	}
}