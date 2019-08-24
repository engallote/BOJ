import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] visit;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		visit = new boolean[N][M];
		
		Queue<Pair> ji = new LinkedList<>(), f = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'J')
				{
					ji.add(new Pair(i, j));
					visit[i][j] = true;
				}
				else if(arr[i][j] == 'F')
					f.add(new Pair(i, j));
			}
		}
		
		boolean flag = false;
		int time = 0;
		while(!ji.isEmpty())
		{
			time++;
			int size = f.size();
			
			for(int i = 0; i < size; i++)
			{
				Pair ff = f.poll();
				for(int j = 0; j < 4; j++)
				{
					int nx = ff.x + dx[j], ny = ff.y + dy[j];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(arr[nx][ny] == '.')
					{
						arr[nx][ny] = 'F';
						f.offer(new Pair(nx, ny));
					}
				}
			}
			
			size = ji.size();
			for(int i = 0; i < size; i++)
			{
				Pair jj = ji.poll();
				for(int j = 0; j < 4; j++)
				{

					int nx = jj.x + dx[j], ny = jj.y + dy[j];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					{
						flag = true;
						break;
					}
					else if(arr[nx][ny] == '.' && !visit[nx][ny])
					{
						visit[nx][ny] = true;
						ji.offer(new Pair(nx, ny));
					}
				}
				if(flag) break;
			}
			if(flag) break;
		}
		if(flag)
			System.out.println(time);
		else
			System.out.println("IMPOSSIBLE");
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