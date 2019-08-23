import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] visit;
	static int[][] map;
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		int[] kx = {-2, -2, -1, -1, 1, 1, 2, 2}, ky = {1, -1, 2, -2, 2, -2, 1, -1};
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		int cnt = 1;//1은 퀸, 2는 나이트, 3은 pawn
		
		for(int i = 0; i < 3; i++)
		{
			int n = sc.nextInt();
			for(int j = 0; j < n; j++)
			{
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				map[x][y] = cnt;
				visit[x][y] = true;
				if(cnt <= 2)
					q.add(new Pair(x, y, cnt));
			}
			cnt++;
		}
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.who == 1)
			{
				for(int i = 0; i < 8; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					while(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0)
					{
						visit[nx][ny] = true;
						nx += dx[i];
						ny += dy[i];
					}
				}
			}
			else if(p.who == 2)
			{
				for(int i = 0; i < 8; i++)
				{
					int nx = p.x + kx[i], ny = p.y + ky[i];
					if(nx >= 0 && ny >= 0 && nx < N && ny < M)
						visit[nx][ny] = true;
				}
			}
		}
		
		cnt = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
//				System.out.print((visit[i][j] ? 1 : 0) + " ");
				if(!visit[i][j])
					cnt++;
			}
//			System.out.println();
		}
		System.out.println(cnt);
	}
}
class Pair{
	int x, y, who;
	Pair(int x, int y, int who)
	{
		this.x = x;
		this.y = y;
		this.who = who;
	}
}