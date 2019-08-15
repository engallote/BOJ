import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][][] chk = new int[N][N][2];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
			}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, 0, 1));
		chk[0][0][0] = chk[0][0][1] = 0;
		int time = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.x == N - 1 && p.y == N - 1)
			{
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				time = p.cnt + 1;
				if(arr[nx][ny] == 1 && chk[nx][ny][p.k] > time) 
				{
					chk[nx][ny][p.k] = time;
					pq.offer(new Pair(nx, ny, time, p.k));
				}
				else if(arr[p.x][p.y] == 1 && arr[nx][ny] == 0 && p.k == 1)
				{
					while(time % M != 0) time++;
					if(chk[nx][ny][0] > time)
					{
						chk[nx][ny][0] = time;
						pq.offer(new Pair(nx, ny, time, 0));
					}
				}
				else if(arr[p.x][p.y] == 1 && arr[nx][ny] >= 2)
				{
					while(time % arr[nx][ny] != 0) time++;
					if(chk[nx][ny][p.k] > time)
					{
						chk[nx][ny][p.k] = time;
						pq.offer(new Pair(nx, ny, time, p.k));
					}
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt, k;
	Pair(int x, int y, int cnt, int k){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}