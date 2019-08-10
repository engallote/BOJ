import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A = sc.nextInt() - 1;
		int B = sc.nextInt() - 1;
		int k = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] arr = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < k; i++)
			arr[sc.nextInt()-1][sc.nextInt()-1] = -1;
		
		int sx = sc.nextInt() - 1;
		int sy = sc.nextInt() - 1;
		int ex = sc.nextInt() - 1;
		int ey = sc.nextInt() - 1;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sx, sy, 0));
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.x == ex && p.y == ey)
			{
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[nx][ny] == -1) continue;
				if(nx + A < 0 || ny + B < 0 || nx + A >= N || ny + B >= M) continue;
				boolean flag = false;
				for(int a = nx; a <= nx + A; a++)
				{
					for(int l = ny; l <= ny + B; l++)
						if(arr[a][l] == -1)
						{
							flag = true;
							break;
						}
					if(flag) break;
				}
				if(!flag)
				{
					visit[nx][ny] = true;
					q.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}