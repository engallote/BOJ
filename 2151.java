import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		int[][] chk = new int[N][N];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int sx = -1, sy = 0, ex = 0, ey = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(chk[i], 100000000);
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				if(arr[i][j] == '#')
				{
					if(sx == -1)
					{
						sx = i;
						sy = j;
					}
					else
					{
						ex = i;
						ey = j;
					}
				}
		}
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sx, sy));
		chk[sx][sy] = 0;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			
			if(p.x == ex && p.y == ey)
			{
				System.out.println(chk[ex][ey]);
				break;
			}
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				while(nx >= 0 && ny >= 0 && nx < N && ny < N) 
				{
					if(arr[nx][ny] == '!')
					{
						if(chk[nx][ny] > chk[p.x][p.y] + 1)
						{
							chk[nx][ny] = chk[p.x][p.y] + 1;
							q.add(new Pair(nx, ny));
						}
					}
					else if(nx == ex && ny == ey)
					{
						chk[nx][ny] = Math.min(chk[p.x][p.y], chk[nx][ny]);
						q.add(new Pair(nx, ny));
						break;
					}
					else if(arr[nx][ny] == '*') break;
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
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