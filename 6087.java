import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		char[][] arr = new char[N][M];
		int[][] chk = new int[N][M];
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
		int sx = -1, sy = 0, ex = -1, ey = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(chk[i], Integer.MAX_VALUE);
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 'C')
				{
					if(sx == -1)
					{
						sx = i;
						sy = j;
					}
					else
					{
						ex = i;
						ey = j;
					}
				}
		}
		chk[sx][sy] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(sx, sy, 0, 0));
		pq.add(new Pair(sx, sy, 1, 0));
		pq.add(new Pair(sx, sy, 2, 0));
		pq.add(new Pair(sx, sy, 3, 0));
		int res = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
//			System.out.println(p.x + " " + p.y);
			if(p.x == ex && p.y == ey)
			{
				res = p.cnt;
				break;
			}
			if(p.d < 2)//상하 방향은 좌우로 퍼진다
			{
				for(int i = 2; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '*' || chk[nx][ny] < p.cnt + 1)
						continue;
					chk[nx][ny] = p.cnt + 1;
					pq.add(new Pair(nx, ny, i, p.cnt + 1));
				}
			}
			else//좌우 방향은 상하로 퍼진다
			{
				for(int i = 0; i < 2; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '*' || chk[nx][ny] < p.cnt + 1)
						continue;
					chk[nx][ny] = p.cnt + 1;
					pq.add(new Pair(nx, ny, i, p.cnt + 1));
				}
			}
			int nx = p.x + dx[p.d], ny = p.y + dy[p.d];
			if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] != '*')
			{
				if(arr[nx][ny] != '*' && chk[nx][ny] >= p.cnt)
				{
					chk[nx][ny] = p.cnt;
					pq.add(new Pair(nx, ny, p.d, p.cnt));//그 방향 그대로
				}
			}
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, d, cnt;
	Pair(int x, int y, int d, int cnt){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}