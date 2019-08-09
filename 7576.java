import java.util.*;

public class Main {
	static int N, M, day;
	static Queue<Pair> q = new LinkedList<>();
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)
					q.add(new Pair(i, j));
			}
		
		if(q.size() == N * M)
		{
			System.out.println(0);
			return;
		}
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.x + 1 < N && map[p.x+1][p.y] == 0)
			{
				map[p.x+1][p.y] = map[p.x][p.y] + 1;
				q.offer(new Pair(p.x+1, p.y));
			}
			if(p.x - 1 >= 0 && map[p.x-1][p.y] == 0)
			{
				map[p.x-1][p.y] = map[p.x][p.y] + 1;
				q.offer(new Pair(p.x-1, p.y));
			}
			if(p.y + 1 < M && map[p.x][p.y+1] == 0)
			{
				map[p.x][p.y+1] = map[p.x][p.y] + 1;
				q.offer(new Pair(p.x, p.y+1));
			}
			if(p.y - 1 >= 0 && map[p.x][p.y-1] == 0)
			{
				map[p.x][p.y-1] = map[p.x][p.y] + 1;
				q.offer(new Pair(p.x, p.y-1));
			}
			
			if(check())
				break;
		}
		
		if(check())
			System.out.println(day-1);
		else
			System.out.println(-1);
		
	}
	private static boolean check() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				if(day < map[i][j])
					day = map[i][j];
				if(map[i][j] == 0) return false;
			}
		return true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}