import java.util.*;

public class Main {
	static int N, M, res, tmp;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new char[N][M];
			res = 0;
			int x = -1, y = 0;
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] == '.')
					{
						int sum = 0;
						if(i - 1 >= 0 && arr[i-1][j] == '#') sum++;
						if(i + 1 < N && arr[i+1][j] == '#') sum++;
						if(j - 1 >= 0 && arr[i][j-1] == '#') sum++;
						if(j + 1 < M && arr[i][j+1] == '#') sum++;
						
						if(sum >= 3 && x == -1)
						{
							x = i;
							y = j;
						}
					}
			
			int cnt = 0;
			Queue<Pair> q = new LinkedList<>();
			for(int a = 0; a < 2; a++)
			{
				chk = new boolean[N][M];
				chk[x][y] = true;
				q.clear();
				q.add(new Pair(x, y));
				cnt = 0;
				while(!q.isEmpty())
				{
					cnt++;
					int size = q.size();
					
					for(int i = 0; i < size; i++)
					{
						Pair p = q.poll();
						
						for(int k = 0; k < 4; k++)
						{
							int nx = p.x + dx[k], ny = p.y + dy[k];
							if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#' || chk[nx][ny])
								continue;
							chk[nx][ny] = true;
							q.add(new Pair(nx, ny));
							x = nx;
							y = ny;
						}
					}
				}
			}
			System.out.println("Maximum rope length is " + (cnt-1) + ".");
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