import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			int x = sc.nextInt();
			int y = sc.nextInt();
			int gx = sc.nextInt();
			int gy = sc.nextInt();
			visit[x][y] = true;
			Queue<Pair> q = new LinkedList<>();
			q.offer(new Pair(x, y, 0));
			
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				if(p.x == gx && p.y == gy)
				{
					System.out.println(p.cnt);
					break;
				}
				
				if(p.x - 2 >= 0)
				{
					if(p.y - 1 >= 0 && !visit[p.x-2][p.y-1])
					{
						visit[p.x-2][p.y-1] = true;
						q.offer(new Pair(p.x-2, p.y-1, p.cnt + 1));
					}
					if(p.y + 1 < N && !visit[p.x-2][p.y+1])
					{
						visit[p.x-2][p.y+1] = true;
						q.offer(new Pair(p.x-2, p.y+1, p.cnt + 1));
					}
				}
				if(p.x - 1 >= 0)
				{
					if(p.y - 2 >= 0 && !visit[p.x-1][p.y-2])
					{
						visit[p.x-1][p.y-2] = true;
						q.offer(new Pair(p.x-1, p.y-2, p.cnt + 1));
					}
					if(p.y + 2 < N && !visit[p.x-1][p.y+2])
					{
						visit[p.x-1][p.y+2] = true;
						q.offer(new Pair(p.x-1, p.y+2, p.cnt + 1));
					}
				}
				if(p.x + 1 < N){
					if(p.y - 2 >= 0 && !visit[p.x+1][p.y-2])
					{
						visit[p.x+1][p.y-2] = true;
						q.offer(new Pair(p.x+1, p.y-2, p.cnt + 1));
					}
					if(p.y + 2 < N && !visit[p.x+1][p.y+2])
					{
						visit[p.x+1][p.y+2] = true;
						q.offer(new Pair(p.x+1, p.y+2, p.cnt + 1));
					}
				}
				if(p.x + 2 < N)
				{
					if(p.y - 1 >= 0 && !visit[p.x+2][p.y-1])
					{
						visit[p.x+2][p.y-1] = true;
						q.offer(new Pair(p.x+2, p.y-1, p.cnt + 1));
					}
					if(p.y + 1 < N && !visit[p.x+2][p.y+1])
					{
						visit[p.x+2][p.y+1] = true;
						q.offer(new Pair(p.x+2, p.y+1, p.cnt + 1));
					}
				}
			}
		}
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}