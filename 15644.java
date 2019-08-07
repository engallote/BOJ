import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		char[] p = {'D', 'R', 'U', 'L'};
		boolean[][][][] chk = new boolean[N][M][N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Pair r = new Pair(0, 0), b = new Pair(0, 0);
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'R') r = new Pair(i, j, 0 , "");
				else if(arr[i][j] == 'B') b = new Pair(i, j, 0, "");
			}
		}
		chk[r.x][r.y][b.x][b.y] = true;
		ArrayList<Pair> aly = new ArrayList<>();
		aly.add(r);
		aly.add(b);
		Queue<ArrayList<Pair>> q = new LinkedList<>();
		q.add(aly);
		
		while(!q.isEmpty())
		{
			ArrayList<Pair> cur = q.poll();
			r = cur.get(0);
			b = cur.get(1);
			
			for(int i = 0; i < 4; i++)
			{
				int rx = r.x, ry = r.y, bx = b.x, by = b.y, cnt = r.cnt;
				String path = r.path;
				boolean rh = false, bh = false;
				while(check(bx + dx[i], by + dy[i]))
				{
					bx += dx[i];
					by += dy[i];
					if(arr[bx][by] == 'O') bh = true;
				}
				while(check(rx + dx[i], ry + dy[i]))
				{
					rx += dx[i];
					ry += dy[i];
					if(arr[rx][ry] == 'O') rh = true;
				}
				path += p[i] + "";
				if(cnt + 1 <= 10 && !bh)
				{
					if(rh)
					{
						System.out.println(cnt + 1);
						System.out.println(path);
						return;
					}
					else
					{
						if(rx == bx && ry == by)
						{
							if(i < 2)
							{
								if(r.x < b.x || r.y < b.y)
								{
									rx -= dx[i];
									ry -= dy[i];
								}
								else
								{
									bx -= dx[i];
									by -= dy[i];
								}
							}
							else
							{
								if(r.x < b.x || r.y < b.y)
								{
									bx -= dx[i];
									by -= dy[i];
								}
								else
								{
									rx -= dx[i];
									ry -= dy[i];
								}
							}
						}
						if(!chk[rx][ry][bx][by])
						{
							chk[rx][ry][bx][by] = true;
							ArrayList<Pair> next = new ArrayList<>();
							next.add(new Pair(rx, ry, cnt + 1, path));
							next.add(new Pair(bx, by, cnt + 1, path));
							q.add(next);
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean check(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M && arr[x][y] != '#') return true;
		else return false;
	}
}
class Pair{
	int x, y, cnt;
	String path;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt, String path)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.path = path;
	}
}