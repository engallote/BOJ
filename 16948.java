import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dx = {-2, -2, 0, 0, 2, 2}, dy = {-1, 1, -2, 2, -1, 1};
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(sc.nextInt(), sc.nextInt()));
		boolean[][] chk = new boolean[N+1][N+1];
		int ex = sc.nextInt();
		int ey = sc.nextInt();
		int size = 0, time = 0;
		chk[q.peek().x][q.peek().y] = true;
		while(!q.isEmpty()){
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.x == ex && p.y == ey)
				{
					System.out.println(time);
					return;
				}
				for(int i = 0; i < 6; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny]) continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			time++;
		}
		System.out.println(-1);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}