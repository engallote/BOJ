import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sx = sc.nextInt()-1;
		int sy = sc.nextInt()-1;
		int ex = sc.nextInt()-1;
		int ey = sc.nextInt()-1;
		int[][] arr = new int[N][M];
		int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
		boolean[][][] visit = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		visit[sx][sy][0] = true;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(sx, sy, 0, 1));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.x == ex && p.y == ey)
			{
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][p.k]) continue;
				if(p.k == 1 && arr[nx][ny] == 1)
				{
					visit[nx][ny][1] = true;
					pq.add(new Pair(nx, ny, p.cnt + 1, 0));
				}
				else if(arr[nx][ny] == 0)
				{
					visit[nx][ny][p.k] = true;
					pq.add(new Pair(nx, ny, p.cnt + 1, p.k));
				}
					
			}
		}
		System.out.println(-1);
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