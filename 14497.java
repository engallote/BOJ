import java.util.*;

public class Main {
	static int N, M, ex, ey;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new boolean[N][M];
		Queue<Pair> q = new LinkedList<Pair>();
		
		int sx = sc.nextInt() - 1, sy = sc.nextInt() - 1;
		ex = sc.nextInt() - 1;
		ey = sc.nextInt() - 1;
		
		chk[sx][sy] = true;
		q.offer(new Pair(sx, sy));
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) if(arr[i][j] == '#') arr[i][j] = '1';
		}
		
		
		System.out.println(bfs(q));
	}
	private static int bfs(Queue<Pair> q) {
		int size = 0, time = 0;
		Queue<Pair> zero = new LinkedList<Pair>();
		
		while(!q.isEmpty())
		{
			size = q.size();
			while(size > 0)
			{
				size--;
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey) return time;
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
					
					if(arr[nx][ny] == '1')
					{
						chk[nx][ny] = true;
						arr[nx][ny] = '0';
						q.offer(new Pair(nx, ny));
						continue;
					}
					while(nx >= 0 && ny >= 0 && nx < N && ny < M)
					{
						if(chk[nx][ny] || arr[nx][ny] != '0') break;
						chk[nx][ny] = true;
						zero.offer(new Pair(nx, ny));
						nx += dx[i];
						ny += dy[i];
					}
				}
			}
			
			while(!zero.isEmpty())
			{
				Pair p = zero.poll();
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
					chk[nx][ny] = true;
					if(arr[nx][ny] == '1')
					{
						arr[nx][ny] = '0';
						q.offer(new Pair(nx, ny));
						continue;
					}
					else zero.offer(new Pair(nx, ny));
				}
			}
			
			time++;
		}
		return 0;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}