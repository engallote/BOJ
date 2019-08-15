import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		boolean[][][] chk = new boolean[8][8][9];
		for(int i = 0; i < 8; i++)
			arr[i] = sc.next().toCharArray();
		
		int[] dx = {0, 1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 0, 1, 0, -1, 1, -1, 1, -1};
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(7, 0));
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.x == 0 && p.y == 7)
				{
					System.out.println(1);
					return;
				}
				if(arr[p.x][p.y] == '#') continue;
				for(int i = 0; i < 9; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8 || chk[nx][ny][i] || arr[nx][ny] != '.')
						continue;
					chk[nx][ny][i] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			for(int i = 7; i > 0; i--)
				for(int j = 0; j < 8; j++)
					arr[i][j] = arr[i-1][j];
			Arrays.fill(arr[0], '.');
		}
		System.out.println(0);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}