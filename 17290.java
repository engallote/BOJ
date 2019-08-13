import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
		char[][] arr = new char[10][10];
		int[][] chk = new int[10][10];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < 10; i++)
		{
			Arrays.fill(chk[i], 10000000);
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < 10; j++)
				if(arr[i][j] == 'o') q.add(new Pair(i, j));
		}
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			
			for(int i = 0; i < 10; i++)
			{
				arr[p.x][i] = 'o';
				arr[i][p.y] = 'o';
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(x, y, 0));
		chk[x][y] = 0;
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(arr[p.x][p.y] == 'x')
			{
				System.out.println(p.cnt);
				break;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10 || chk[nx][ny] < p.cnt + 1) continue;
				chk[nx][ny] = p.cnt + 1;
				pq.add(new Pair(nx, ny, p.cnt + 1));
			}
		}
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