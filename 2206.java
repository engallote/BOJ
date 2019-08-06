import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] arr = new int[N][M];
		boolean[][][] visit = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				arr[i][j] = c[j] - '0';
		}
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(0, 0, 1, 1));
		visit[0][0][0] = true;
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.x == N - 1 && p.y == M - 1)
			{
				System.out.println(p.cnt);
				return;
			}
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][p.k]) continue;
				if(arr[nx][ny] == 1 && p.k == 1)
				{
					visit[nx][ny][1] = true;
					q.add(new Pair(nx, ny, p.cnt + 1, 0));
				}
				else if(arr[nx][ny] == 0)
				{
					visit[nx][ny][p.k] = true;
					q.add(new Pair(nx, ny, p.cnt + 1, p.k));
				}
			}
		}
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt, k;
	Pair(int x, int y, int cnt, int k)
	{
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