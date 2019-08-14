import java.util.*;

public class Main {
	static char[][] arr =  new char[10][10];
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	static boolean[][] chk = new boolean[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < 10; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < 10; j++)
				if(arr[i][j] == 'X')
					q.add(new Pair(i, j));
		}
		boolean flag = false;
		while(!q.isEmpty() && !flag)
		{
			Pair p = q.poll();
			
			for(int k = 0; k < 8; k++)
			{
				int nx = p.x + dx[k], ny = p.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10 || arr[nx][ny] != '.') continue;
				arr[nx][ny] = 'X';
				chk = new boolean[10][10];
//				for(int i = 0; i < 10; i++)
//				{
//					for(int j = 0; j < 10; j++)
//						System.out.print(arr[i][j]);
//					System.out.println();
//				}
				for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < 10; j++)
						if(arr[i][j] == 'X')
							if(bfs(i, j)) 
							{
								flag = true;
								break;
							}
							
					if(flag) break;
				}
				if(flag) break;
				arr[nx][ny] = '.';
			}
		}
		
		System.out.println(flag ? 1 : 0);
	}
	private static boolean bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		chk[x][y] = true;

		for(int i = 0; i < 8; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10 || arr[nx][ny] != 'X' || chk[nx][ny]) continue;
			chk[nx][ny] = true;
			int cnt = 1;
			while(nx >= 0 && ny >= 0 && nx < 10 && ny < 10)
			{
				if(arr[nx][ny] != 'X') break;
				nx += dx[i];
				ny += dy[i];
				cnt++;
				if(cnt >= 5) return true;
			}
			q.add(new Pair(nx, ny));
		}
		
		return false;
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}