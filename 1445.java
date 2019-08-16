import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		long[][] gCnt = new long[N][M];
		long[][] chk = new long[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<Pair>();
		int sx = 0, sy = 0, ex = 0, ey = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(chk[i], Long.MAX_VALUE);
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'S')
				{
					q.offer(new Pair(i, j, 0));
					sx = i;
					sy = j;
				}
				else if(arr[i][j] == 'F')
				{
					ex = i;
					ey = j;
				}
			}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 'g')
				{
					gCnt[i][j] = 10000;
					for(int k = 0; k < 4; k++)
					{
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'g') continue;
						gCnt[nx][ny] = 1;
					}
				}
		
		gCnt[ex][ey] = chk[sx][sy] = gCnt[sx][sy] = 0;
		int size = 0;
		long ret = Long.MAX_VALUE;
		
		while(!q.isEmpty())
		{
			size = q.size();
			while(size > 0)
			{
				Pair p = q.poll();
				size--;
				if(arr[p.x][p.y] == 'F')
				{
					ret = Math.min(ret, p.g);
					continue;
				}
				if(p.g > ret) continue;
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] <= p.g + gCnt[nx][ny]) 
						continue;
					chk[nx][ny] = p.g + gCnt[nx][ny];
					q.offer(new Pair(nx, ny, p.g + gCnt[nx][ny]));
				}
			}
		}
		
		System.out.println((chk[ex][ey] / 10000) + " " + (chk[ex][ey] % 10000));
	}
}
class Pair{
	int x, y;
	long g;
	Pair(int x, int y, long g){
		this.x = x;
		this.y = y;
		this.g = g;
	}
}