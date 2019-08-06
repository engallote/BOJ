import java.util.*;

public class Main {
	static int N, M, H, day;
	static Queue<Point> q = new LinkedList<>();
	static int[][][] map;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[N][M][H];
		
		for(int k = 0; k < H; k++)
		{
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
				{
					map[i][j][k] = sc.nextInt();
					if(map[i][j][k] == 1)
						q.add(new Point(i, j, k));
				}
		}
		
		if(check())
		{
			System.out.println(0);
			return;
		}
		while(!q.isEmpty())
		{
			Point p = q.poll();
			if(p.x + 1 < N && map[p.x+1][p.y][p.z] == 0)
			{
				map[p.x+1][p.y][p.z] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x+1, p.y, p.z));
			}
			if(p.x - 1 >= 0 && map[p.x-1][p.y][p.z] == 0)
			{
				map[p.x-1][p.y][p.z] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x-1, p.y, p.z));
			}
			if(p.y + 1 < M && map[p.x][p.y+1][p.z] == 0)
			{
				map[p.x][p.y+1][p.z] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x, p.y+1, p.z));
			}
			if(p.y - 1 >= 0 && map[p.x][p.y-1][p.z] == 0)
			{
				map[p.x][p.y-1][p.z] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x, p.y-1, p.z));
			}
			if(p.z + 1 < H && map[p.x][p.y][p.z+1] == 0)
			{
				map[p.x][p.y][p.z+1] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x, p.y, p.z+1));
			}
			if(p.z - 1 >= 0 && map[p.x][p.y][p.z-1] == 0)
			{
				map[p.x][p.y][p.z-1] = map[p.x][p.y][p.z] + 1;
				q.offer(new Point(p.x, p.y, p.z-1));
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
		for(int k = 0; k < H; k++)
		{
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
//					System.out.print(map[i][j][k] + " ");
					if(day < map[i][j][k])
						day = map[i][j][k];
					if(map[i][j][k] == 0) return false;
				}
//				System.out.println();
			}
//			System.out.println();
		}
		return true;
	}
}
class Point{
	int x, y, z;
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}