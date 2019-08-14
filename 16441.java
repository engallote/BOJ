import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		boolean[][] chk = new boolean[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'W')
				{
					chk[i][j] = true;
					q.add(new Pair(i, j));
				}
				else if(arr[i][j] == '#') chk[i][j] = true;
			}
		}
		
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == '#')
						continue;
					
					if(arr[nx][ny] == '.')
					{
						chk[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
					else if(arr[nx][ny] == '+')//ºùÆÇ
					{
						while(nx >= 0 && ny >= 0 && nx < N && ny < M)
						{
							nx += dx[i];
							ny += dy[i];
							if(arr[nx][ny] == '#')
							{
								nx -= dx[i];
								ny -= dy[i];
								if(!chk[nx][ny])
								{
									chk[nx][ny] = true;
									q.add(new Pair(nx, ny));
								}
								break;
							}
							if(arr[nx][ny] == '.')
							{
								if(!chk[nx][ny])
								{
									chk[nx][ny] = true;
									q.add(new Pair(nx, ny));
								}
								break;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
				System.out.print(chk[i][j] ? arr[i][j] : arr[i][j] == '.' ? 'P' : arr[i][j]);
			System.out.println();
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}