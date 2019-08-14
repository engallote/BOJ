import java.util.*;

public class Main {
	static int N, R, C;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N+1][N+1];
		chk = new boolean[N+1][N+1];
		arr[R][C] = 1;
		int size = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(R, C));
		
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				for(int x = p.x, y = p.y; x <= N && y <= N; x++,y++)
				{
					if(arr[x][y] == 1) continue;
					arr[x][y] = 1;
					q.add(new Pair(x, y));
				}
				for(int x = p.x, y = p.y; x >= 1 && y <= N; x--,y++)
				{
					if(arr[x][y] == 1) continue;
					arr[x][y] = 1;
					q.add(new Pair(x, y));
				}
				for(int x = p.x, y = p.y; x <= N && y >= 1; x++,y--)
				{
					if(arr[x][y] == 1) continue;
					arr[x][y] = 1;
					q.add(new Pair(x, y));
				}
				for(int x = p.x, y = p.y; x >= 1 && y >= 1; x--,y--)
				{
					if(arr[x][y] == 1) continue;
					arr[x][y] = 1;
					q.add(new Pair(x, y));
				}
			}
		}
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
				System.out.print(arr[i][j] == 1 ? 'v' : '.');
			System.out.println();
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}