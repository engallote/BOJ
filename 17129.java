import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] arr = new int[N][M];
		boolean[][] chk = new boolean[N][M];
		
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = c[j] - '0';
				if(arr[i][j] == 2)
				{
					arr[i][j] = 0;
					q.add(new Pair(i, j));
					chk[i][j] = true;
				}
			}
		}
		int size = 0, time = 0;
		boolean flag = false;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				
				if(arr[p.x][p.y] > 2)
				{
					flag = true;
					break;
				}
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
			if(flag) break;
			time++;
		}
		
		System.out.println(flag ? ("TAK\n" + time) : "NIE");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}