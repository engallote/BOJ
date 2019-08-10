import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				arr[i][j] = c[j] - '0';
		}
		
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < M; i++)
			if(arr[0][i] == 0)
			{
				visit[0][i] = true;
				q.add(new Pair(0, i));
			}
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || visit[nx][ny])
					continue;
				if(nx == N - 1)
				{
					System.out.println("YES");
					return;
				}
				visit[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
		System.out.println("NO");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}