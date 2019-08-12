import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		boolean[][] chk = new boolean[N][M];
		int[] dx = {1, 0}, dy = {0, 1};
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		int size = 0, time = 0;
		
		while(!q.isEmpty())
		{
			size = q.size();
			
			while(size > 0)
			{
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1)
				{
					q.clear();
					System.out.println(time);
					break;
				}
				
				for(int jump = 1; jump <= arr[p.x][p.y]; jump++)
				{
					for(int i = 0; i < 4; i++)
					{
						int nx = p.x + dx[i] * jump, ny = p.y + dy[i] * jump;
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
						chk[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
				size--;
			}
			time++;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}