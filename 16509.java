import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(sc.nextInt(), sc.nextInt()));
		boolean[][] arr = new boolean[10][9];
		arr[q.peek().x][q.peek().y] = true;
		int ex = sc.nextInt();
		int ey = sc.nextInt();
		int size = 0, time = 0;
		int[][] dx = {{-1, -1, -1}, {-1, -1, -1}, {0, -1, -1}, {0, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, -1, -1}, {0, 1, 1}};
		int[][] dy = {{0, -1, -1}, {0, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, -1, -1}, {0, 1, 1}, {-1, -1, -1}, {-1, -1, -1}};
		
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.x == ex && p.y == ey)
				{
					System.out.println(time);
					return;
				}
				for(int i = 0; i < 8; i++)
				{
					int nx = p.x, ny = p.y;
					boolean flag = true;
					for(int j = 0; j < 3; j++)
					{
						nx += dx[i][j];
						ny += dy[i][j];
						if(nx < 0 || ny < 0 || nx > 9 || ny > 8 || (j < 2 && nx == ex && ny == ey))
						{
							flag = false;
							break;
						}
					}
					if(flag && !arr[nx][ny])
					{
						arr[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
			}
			time++;
		}
		System.out.println(-1);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}