import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		String[] d = {"S", "E", "N", "W"};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] arr = new char[N][M];
			boolean[][][][] chk = new boolean[N][M][N][M];
			Queue<Pair> q = new LinkedList<>();
			Pair a = new Pair(-1, 0), b = new Pair(0, 0);
			for(int i = 0; i < N; i++)
			{
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < M; j++)
					if(arr[i][j] == 'P')
					{
						q.add(new Pair(i, j, ""));
						if(a.x == -1) a = new Pair(i, j);
						else b = new Pair(i, j);
					}
			}
			chk[a.x][a.y][b.x][b.y] = true;
			boolean flag = false;
			int time = 0, size = 0;
			String path = "";
			while(!q.isEmpty())
			{
				size = q.size();
				for(int t = 0; t < size / 2; t++)
				{
					Pair p1 = q.poll();
					Pair p2 = q.poll();
					if(p1.x == p2.x && p1.y == p2.y)
					{
						flag = true;
						path = p1.str;
						break;
					}
					for(int i = 0; i < 4; i++)
					{
						int nx1 = p1.x + dx[i], ny1 = p1.y + dy[i];
						int nx2 = p2.x + dx[i], ny2 = p2.y + dy[i];
						if(nx1 < 0 || ny1 < 0 || nx1 >= N || ny1 >= M)
						{
							if(nx1 < 0) nx1 = N - 1;
							else if(nx1 >= N) nx1 = 0;
							else if(ny1 < 0) ny1 = M - 1;
							else ny1 = 0;
						}
						if(nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M)
						{
							if(nx2 < 0) nx2 = N - 1;
							else if(nx2 >= N) nx2 = 0;
							else if(ny2 < 0) ny2 = M - 1;
							else if(ny2 >= M) ny2 = 0;
						}
						if(arr[nx1][ny1] == 'X')
						{
							nx1 = p1.x;
							ny1 = p1.y;
						}
						if(arr[nx2][ny2] == 'X')
						{
							nx2 = p2.x;
							ny2 = p2.y;
						}
						if(arr[nx1][ny1] == 'G' || arr[nx2][ny2] == 'G' || chk[nx1][ny1][nx2][ny2]) 
							continue;
						chk[nx1][ny1][nx2][ny2] = true;
						q.add(new Pair(nx1, ny1, p1.str + d[i]));
						q.add(new Pair(nx2, ny2));
					}
				}
				if(flag) break;
				time++;
			}
			if(flag) System.out.println(time + " " + path);
			else System.out.println("IMPOSSIBLE");
		}
	}
}
class Pair{
	int x, y;
	String str;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, String str)
	{
		this.x = x;
		this.y = y;
		this.str = str;
	}
}