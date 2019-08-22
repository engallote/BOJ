import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] dx = {0, 0, 0, 1, -1}, dy = {0, 1, -1, 0, 0};
		int[][] arr = new int[M][N];
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
			arr[i][j] = sc.nextInt();
		
		boolean[][][] visit = new boolean[M][N][5];
		int sx = sc.nextInt()-1;
		int sy = sc.nextInt()-1;
		int sdir = sc.nextInt();
		
		int ex = sc.nextInt()-1;
		int ey = sc.nextInt()-1;
		int edir = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy, sdir, 0));
		visit[sx][sy][sdir] = true;
	
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.x == ex && p.y == ey && p.dir == edir)
			{
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 1; i <= 4; i++)
			{
				if(p.dir == i) continue;
				if(visit[p.x][p.y][i]) continue;
				visit[p.x][p.y][i] = true;
				if(find(p.dir) == i)//180도 턴 할 경우
					q.offer(new Pair(p.x, p.y, i, p.cnt + 2));
				else
					q.offer(new Pair(p.x, p.y, i, p.cnt + 1));
			}
			
			for(int i = 1; i <= 3; i++)
			{
				int nx = p.x + dx[p.dir] * i, ny = p.y + dy[p.dir] * i;
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) break;
				if(arr[nx][ny] == 1) break;
				if(!visit[nx][ny][p.dir])
				{
					visit[nx][ny][p.dir] = true;
					q.offer(new Pair(nx, ny, p.dir, p.cnt+1));
				}
			}
		}
	}

	private static int find(int dir) {
		if(dir == 1) return 2;
		else if(dir == 2) return 1;
		else if(dir == 3) return 4;
		else return 3;
	}
}
class Pair{
	int x, y, dir, cnt;
	Pair(int x, int y, int dir, int cnt)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}
}