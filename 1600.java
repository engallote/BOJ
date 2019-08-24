import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int[][] arr = new int[H][W];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[] dx2 = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] dy2 = {-1, 1, -2, 2, -2, 2, -1, 1};
		boolean[][][] visit = new boolean[H][W][K+1];
		
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				arr[i][j] = sc.nextInt();
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0, K));
		visit[0][0][K] = true;
		
		boolean flag = false;
		int cnt = -1;
		while(!q.isEmpty())
		{			
			int size = q.size();
			for(int j = 0; j < size; j++)
			{
				Point p = q.poll();
				if(p.x == H - 1 && p.y == W - 1)
				{
					cnt = p.cnt;
					flag = true;
					break;
				}
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || visit[nx][ny][p.k]) continue;
					visit[nx][ny][p.k] = true;
					q.offer(new Point(nx, ny, p.cnt + 1, p.k));
				}
				if(p.k > 0)
				{
					for(int i = 0; i < 8; i++)
					{
						int nx = p.x + dx2[i], ny = p.y + dy2[i];
						if(nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || visit[nx][ny][p.k-1]) continue;
						visit[nx][ny][p.k-1] = true;
						q.offer(new Point(nx, ny, p.cnt + 1, p.k - 1));
					}
				}	
			}
			if(flag) break;
		}
		System.out.println(cnt);
	}
}
class Point{
	int x, y, cnt, k;
	Point(int x, int y, int cnt, int k)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
}