import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		boolean[][][][] chk = new boolean[N][M][N][M];
		Queue<ArrayList<Pair>> q = new LinkedList<>();
		Pair R = new Pair(0, 0, 0), B = new Pair(0, 0, 0);
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'R') R = new Pair(i, j, 0);
				else if(arr[i][j] == 'B') B = new Pair(i, j, 0);
			}
		}
		ArrayList<Pair> aly = new ArrayList<>();
		aly.add(R);
		aly.add(B);
		q.add(aly);
		chk[R.x][R.y][B.x][B.y] = true;
		int res = -1, size = 0;
		boolean flag = false;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				aly = q.poll();
				R = aly.get(0);
				B = aly.get(1);
				
				for(int i = 0; i < 4; i++)
				{
					boolean rh = false, bh = false;
					int rx = R.x + dx[i], ry = R.y + dy[i], bx = B.x + dx[i], by = B.y + dy[i];
					
					while(bx >= 0 && by >= 0 && bx < N && by < M)
					{
						if(arr[bx][by] == '#')
						{
							bx -= dx[i];
							by -= dy[i];
							break;
						}
						else if(arr[bx][by] == 'O') bh = true;
						bx += dx[i];
						by += dy[i];
					}
					
					while(rx >= 0 && ry >= 0 && rx < N && ry < M)
					{
						if(arr[rx][ry] == '#')
						{
							rx -= dx[i];
							ry -= dy[i];
							break;
						}
						else if(arr[rx][ry] == 'O') rh = true;
						rx += dx[i];
						ry += dy[i];
					}
					
					if(!bh)
					{
						if(rh)
						{
							flag = true;
							res = R.cnt + 1;
							break;
						}
						if(rx == bx && ry == by)
						{
							if(i < 2)
							{
								if(R.x < B.x || R.y < B.y)
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
								if(R.x < B.x || R.y < B.y)
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
							next.add(new Pair(rx, ry, R.cnt + 1));
							next.add(new Pair(bx, by, R.cnt + 1));
							q.add(next);
						}
					}
				}
				if(flag) break;
			}
			if(flag) break;
		}
		System.out.println(res);
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}