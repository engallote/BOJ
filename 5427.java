import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int w = sc.nextInt();
			int h = sc.nextInt();
			int[][] arr = new int[h][w];
			boolean[][] visit = new boolean[h][w];
			int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
			int cnt = 0;
			Queue<Point> q = new LinkedList<>(), fire = new LinkedList<>();
			
			for(int i = 0; i < h; i++)
			{
				char[] c = sc.next().toCharArray();
				for(int j = 0; j < w; j++)
				{
					if(c[j] == '#')
						arr[i][j] = -1;
					else if(c[j] == '@')
					{
						q.add(new Point(i, j, 1));
						visit[i][j] = true;
						arr[i][j] = 1;
					}
					else if(c[j] == '*')
					{
						fire.add(new Point(i, j, 2));
						visit[i][j] = true;
						arr[i][j] = 2;
					}
				}
			}
			int min = Integer.MAX_VALUE - 1;
			boolean flag = false;
			while(!q.isEmpty())
			{
				int size = fire.size();
				for(int k = 0; k < size; k++)
				{
					Point f = fire.poll();
					for(int i = 0; i < 4; i++)
					{
						int nx = f.x + dx[i], ny = f.y + dy[i];
						if(nx < h && ny < w && nx >= 0 && ny >= 0 && arr[nx][ny] == 0 && !visit[nx][ny])
						{
							visit[nx][ny] = true;
							fire.offer(new Point(nx, ny, 2));
						}
					}
				}
				size = q.size();
				for(int k = 0; k < size; k++)
				{
					Point p = q.poll();
//					System.out.println(p.x + " " + p.y);
					for(int i = 0; i < 4; i++)
					{
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < h && ny < w && nx >= 0 && ny >= 0 && arr[nx][ny] == 0 && !visit[nx][ny])
						{
							visit[nx][ny] = true;
							q.offer(new Point(nx, ny, p.cnt + 1));
						}
						else if(nx >= h || ny >= w || nx < 0 || ny < 0)
						{
							flag = true;
							min = p.cnt;
							break;
						}
					}
				}
				if(flag) break;
			}
			if(flag)
				System.out.println(min);
			else
				System.out.println("IMPOSSIBLE");
		}	
	}
}
class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}