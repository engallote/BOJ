import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int form = 0;
		int[][] xy = new int[3][2];
		int[][] arr = new int[N][N];
		boolean[][][] visit = new boolean[N][N][2];
		int idx = 0;
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
			{
				if(c[j] == '1')
					arr[i][j] = 1;
				else if(c[j] == 'E')
					arr[i][j] = 2;
				else if(c[j] == 'B')
				{
					xy[idx][0] = i;
					xy[idx][1] = j;
					idx++;
				}
			}
		}
		if(xy[0][0] == xy[1][0])
			form = 0;//수평
		else
			form = 1;//수직
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(xy[1][0], xy[1][1], 0, form));
		visit[xy[1][0]][xy[1][1]][form] = true;
		
		while(!q.isEmpty())
		{
			Point p = q.poll();
			
			if(p.form == 0)
			{
				if(arr[p.x][p.y-1] == 2 && arr[p.x][p.y] == 2 && arr[p.x][p.y+1] == 2)
				{
					System.out.println(p.cnt);
					return;
				}
				if(p.x - 1 >= 0 && p.x + 1 < N && p.y - 1 >= 0 && p.y + 1 < N && !visit[p.x][p.y][1])//T
				{
					if(arr[p.x-1][p.y-1] != 1 && arr[p.x-1][p.y] != 1 && arr[p.x-1][p.y+1] != 1 && arr[p.x+1][p.y-1] != 1 && arr[p.x+1][p.y] != 1 && arr[p.x+1][p.y+1] != 1)
					{
						visit[p.x][p.y][1] = true;
						q.offer(new Point(p.x, p.y, p.cnt+1, 1));
					}
				}
				if(p.y + 2 < N && !visit[p.x][p.y+1][p.form] && arr[p.x][p.y+2] != 1)//R
				{
					visit[p.x][p.y+1][p.form] = true;
					q.offer(new Point(p.x, p.y+1, p.cnt+1, p.form));
				}
				if(p.y - 2 >= 0 && !visit[p.x][p.y-1][p.form] && arr[p.x][p.y-2] != 1)//L
				{
					visit[p.x][p.y-1][p.form] = true;
					q.offer(new Point(p.x, p.y-1, p.cnt+1, p.form));
				}
				if(p.x - 1 >= 0 && !visit[p.x-1][p.y][p.form] && arr[p.x-1][p.y-1] != 1 && arr[p.x-1][p.y] != 1 && arr[p.x-1][p.y+1] != 1)//U
				{
					visit[p.x-1][p.y][p.form] = true;
					q.offer(new Point(p.x-1, p.y, p.cnt+1, p.form));
				}
				if(p.x + 1 < N && !visit[p.x+1][p.y][p.form] && arr[p.x+1][p.y-1] != 1 && arr[p.x+1][p.y] != 1 && arr[p.x+1][p.y+1] != 1)//D
				{
					visit[p.x+1][p.y][p.form] = true;
					q.offer(new Point(p.x+1, p.y, p.cnt+1, p.form));
				}
			}
			else
			{
				if(arr[p.x-1][p.y] == 2 && arr[p.x][p.y] == 2 && arr[p.x+1][p.y] == 2)
				{
					System.out.println(p.cnt);
					return;
				}
				if(p.y - 1 >= 0 && p.y + 1 < N && p.x - 1 >= 0 && p.x + 1 < N && !visit[p.x][p.y][0])//T
				{
					if(arr[p.x-1][p.y-1] != 1 && arr[p.x-1][p.y+1] != 1 && arr[p.x][p.y-1] != 1 && arr[p.x][p.y+1] != 1 && arr[p.x+1][p.y-1] != 1 && arr[p.x+1][p.y+1] != 1)
					{
						visit[p.x][p.y][0] = true;
						q.offer(new Point(p.x, p.y, p.cnt+1, 0));
					}
				}
				if(p.y + 1 < N && p.x - 1 >= 0 && p.x + 1 < N && !visit[p.x][p.y+1][p.form] && arr[p.x-1][p.y+1] != 1 && arr[p.x][p.y+1] != 1 && arr[p.x+1][p.y+1] != 1)//R
				{
					visit[p.x][p.y+1][p.form] = true;
					q.offer(new Point(p.x, p.y+1, p.cnt+1, p.form));
				}
				if(p.y - 1 >= 0 && p.x - 1 >= 0 && p.x + 1 < N && !visit[p.x][p.y-1][p.form] && arr[p.x-1][p.y-1] != 1 && arr[p.x][p.y-1] != 1 && arr[p.x+1][p.y-1] != 1)//L
				{
					visit[p.x][p.y-1][p.form] = true;
					q.offer(new Point(p.x, p.y-1, p.cnt+1, p.form));
				}
				if(p.x - 2 >= 0 && !visit[p.x-1][p.y][p.form] && arr[p.x-2][p.y] != 1)//U
				{
					visit[p.x-1][p.y][p.form] = true;
					q.offer(new Point(p.x-1, p.y, p.cnt+1, p.form));
				}
				if(p.x + 2 < N && !visit[p.x+1][p.y][p.form] && arr[p.x+2][p.y] != 1)//D
				{
					visit[p.x+1][p.y][p.form] = true;
					q.offer(new Point(p.x+1, p.y, p.cnt+1, p.form));
				}
			}
		}
		
		System.out.println(0);
	}
}
class Point{
	int x, y, cnt, form;
	Point(int x, int y, int cnt, int form)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.form = form;
	}
}