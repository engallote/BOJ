import java.util.*;

public class Main {
	static int N, M, res = Integer.MAX_VALUE;
	static int[][] arr, tmp;
	static ArrayList<Pair> camera = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > 0 && arr[i][j] <= 5)
					camera.add(new Pair(arr[i][j], i, j, 0));
			}
		
		solve(0);
		System.out.println(res);
	}
	private static void solve(int idx) {
		if(idx == camera.size())
		{
			spread();
			find();
			return;
		}
		
		if(camera.get(idx).n == 5) solve(idx + 1);
		else if(camera.get(idx).n == 2)
		{
			camera.get(idx).d = 0;
			solve(idx + 1);
			camera.get(idx).d = 1;
			solve(idx + 1);
		}
		else
		{
			int tmp = camera.get(idx).d;
			for(int i = 0; i < 4; i++)
			{
				camera.get(idx).d = i;
				solve(idx + 1);
				camera.get(idx).d = tmp;
			}
		}
	}
	private static void find() {
		int sum = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(tmp[i][j] == 0) sum++;
		
		res = Math.min(res, sum);
	}
	private static void spread() {
		tmp = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				tmp[i][j] = arr[i][j];
		
		for(Pair p : camera)
		{
			int x = p.x, y = p.y;
			if(p.n == 1)
			{
				while(x + dx[p.d] >= 0 && x + dx[p.d] < N && y + dy[p.d] >= 0 && y + dy[p.d] < M)
				{
					if(tmp[x+dx[p.d]][y+dy[p.d]] == 6) break;
					x += dx[p.d];
					y += dy[p.d];
					if(tmp[x][y] == 0 || tmp[x][y] > 5)
						tmp[x][y] = 9;
				}
			}
			else if(p.n == 2)
			{
				if(p.d == 0)
				{
					while(x + dx[p.d] >= 0 && x + dx[p.d] < N && y + dy[p.d] >= 0 && y + dy[p.d] < M)
					{
						if(tmp[x+dx[p.d]][y+dy[p.d]] == 6) break;
						x += dx[p.d];
						y += dy[p.d];
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					y = p.y;
					while(x + dx[p.d+2] >= 0 && x + dx[p.d+2] < N && y + dy[p.d+2] >= 0 && y + dy[p.d+2] < M)
					{
						if(tmp[x+dx[p.d+2]][y+dy[p.d+2]] == 6) break;
						x += dx[p.d+2];
						y += dy[p.d+2];
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else
				{
					while(x + dx[p.d] >= 0 && x + dx[p.d] < N && y + dy[p.d] >= 0 && y + dy[p.d] < M)
					{
						if(tmp[x+dx[p.d]][y+dy[p.d]] == 6) break;
						x += dx[p.d];
						y += dy[p.d];
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					y = p.y;
					while(x + dx[p.d+2] >= 0 && x + dx[p.d+2] < N && y + dy[p.d+2] >= 0 && y + dy[p.d+2] < M)
					{
						if(tmp[x+dx[p.d+2]][y+dy[p.d+2]] == 6) break;
						x += dx[p.d+2];
						y += dy[p.d+2];
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
			}
			else if(p.n == 3)
			{
				if(p.d == 0)
				{
					while(x - 1 >= 0)
					{
						if(tmp[x-1][y] == 6) break;
						x -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y + 1 < M)
					{
						if(tmp[x][y+1] == 6) break;
						y += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else if(p.d == 1)
				{
					while(x + 1 < N)
					{
						if(tmp[x+1][y] == 6) break;
						x += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y + 1 < M)
					{
						if(tmp[x][y+1] == 6) break;
						y += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else if(p.d == 2)
				{
					while(x + 1 < N)
					{
						if(tmp[x+1][y] == 6) break;
						x += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y - 1 >= 0)
					{
						if(tmp[x][y-1] == 6) break;
						y -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else
				{
					while(x - 1 >= 0)
					{
						if(tmp[x-1][y] == 6) break;
						x -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y - 1 >= 0)
					{
						if(tmp[x][y-1] == 6) break;
						y -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
			}
			else if(p.n == 4)
			{
				if(p.d == 0)
				{
					while(x - 1 >= 0)
					{
						if(tmp[x-1][y] == 6) break;
						x -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y + 1 < M)
					{
						if(tmp[x][y+1] == 6) break;
						y += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					y = p.y;
					while(y - 1 >= 0)
					{
						if(tmp[x][y-1] == 6) break;
						y -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else if(p.d == 1)
				{
					while(x - 1 >= 0)
					{
						if(tmp[x-1][y] == 6) break;
						x -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(x + 1 < N)
					{
						if(tmp[x+1][y] == 6) break;
						x += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y + 1 < M)
					{
						if(tmp[x][y+1] == 6) break;
						y += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else if(p.d == 2)
				{
					while(x + 1 < N)
					{
						if(tmp[x+1][y] == 6) break;
						x += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y + 1 < M)
					{
						if(tmp[x][y+1] == 6) break;
						y += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					y = p.y;
					while(y - 1 >= 0)
					{
						if(tmp[x][y-1] == 6) break;
						y -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
				else
				{
					while(x - 1 >= 0)
					{
						if(tmp[x-1][y] == 6) break;
						x -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(x + 1 < N)
					{
						if(tmp[x+1][y] == 6) break;
						x += 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
					x = p.x;
					while(y - 1 >= 0)
					{
						if(tmp[x][y-1] == 6) break;
						y -= 1;
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
			}
			else
			{
				for(int i = 0; i < 4; i++)
				{
					x = p.x;
					y = p.y;
					while(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)
					{
						if(tmp[x + dx[i]][y + dy[i]] == 6) break;
						x += dx[i];
						y += dy[i];
						if(tmp[x][y] == 0 || tmp[x][y] > 5)
							tmp[x][y] = 9;
					}
				}
			}
		}
	}
}
class Pair{
	int n, x, y, d;
	Pair(int n, int x, int y, int d)
	{
		this.n = n;
		this.x = x;
		this.y = y;
		this.d = d;
	}
}