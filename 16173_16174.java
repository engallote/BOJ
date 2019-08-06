import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		boolean[][] chk = new boolean[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		
		boolean flag = false;
		int size;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int i = 0; i < size; i++)
			{
				Pair p = q.poll();
				if(p.x == N - 1 && p.y == N - 1)
				{
					flag = true;
					break;
				}
				if(p.x + arr[p.x][p.y] < N && !chk[p.x + arr[p.x][p.y]][p.y])
				{
					chk[p.x + arr[p.x][p.y]][p.y] = true;
					q.add(new Pair(p.x + arr[p.x][p.y], p.y));
				}
				if(p.y + arr[p.x][p.y] < N && !chk[p.x][p.y + arr[p.x][p.y]])
				{
					chk[p.x][p.y + arr[p.x][p.y]] = true;
					q.add(new Pair(p.x, p.y + arr[p.x][p.y]));
				}
			}
			if(flag) break;
		}
		
		System.out.println(flag ? "HaruHaru" : "Hing");
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