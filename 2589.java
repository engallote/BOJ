import java.util.*;

public class Main {
	static int N, M, max = 0, INF = 1000000;
	static int[][] arr, dp, visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(c[j] == 'W')
					arr[i][j] = -1;
				else
					arr[i][j] = 1;
			}
		}
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 1)
				{
					dp();
					visit = new int[N][M];
					dp[i][j] = 0;
					visit[i][j] = 1;
					bfs(i, j);
				}
		System.out.println(max);
		
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for(int i = 0; i < size; i++)
			{
				Pair p = q.poll();
				for(int j = 0; j < 4; j++)
				{
					int nx = p.x + dx[j], ny = p.y + dy[j];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == -1 || visit[nx][ny] == 1) continue;
					visit[nx][ny] = 1;
					dp[nx][ny] = Math.min(dp[p.x][p.y] + 1, dp[nx][ny]);
					if(max < dp[nx][ny])
						max = dp[nx][ny];
				    q.offer(new Pair(nx, ny));
				}
			}
		}
	}
	private static void dp() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				dp[i][j] = INF;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}