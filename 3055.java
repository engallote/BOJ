import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		char[][] arr = new char[N][M];
		boolean[][] chk = new boolean[N][M];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Queue<Pair> water = new LinkedList<>();
		int res = -1;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
//			Arrays.fill(chk[i], 1000000000);
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'S')
				{
					arr[i][j] = '.';
					pq.add(new Pair(i, j, 0));
				}
				else if(arr[i][j] == '*')
					water.add(new Pair(i, j));
			}
		}
		
		while(!pq.isEmpty())
		{
			int size = water.size();
			Pair p;
			for(int k = 0; k < size; k++)
			{
				p = water.poll();
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != '.') continue;
					arr[nx][ny] = '*';
					water.add(new Pair(nx, ny));
				}
			}
			
			size = pq.size();
			for(int k = 0; k < size; k++)
			{
				p = pq.poll();
				if(arr[p.x][p.y] == 'D')
				{
					res = p.cnt;
					break;
				}
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
					if(arr[nx][ny] == '*' || arr[nx][ny] == 'X') continue;
					chk[nx][ny] = true;
					pq.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
//			for(int i = 0; i < N; i++)
//			{
//				for(int j = 0; j < M; j++)
//					System.out.print(arr[i][j]);
//				System.out.println();
//			}
//			System.out.println("----------------");
		}
		
		System.out.println(res == -1 ? "KAKTUS" : res);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}