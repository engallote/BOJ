import java.util.*;

public class Main {
	static int N, max = 1;
	static int[][] arr, copy;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				if(q.isEmpty())
					q.add(arr[i][j]);
				else if(!q.contains(arr[i][j]))
					q.add(arr[i][j]);
			}
		
		while(!q.isEmpty())
		{
			int water = q.poll(), cnt = 0;
			copy = new int[N][N];
			
			for(int i = 0; i < N; i++)
			{
				Arrays.fill(visit[i], false);
				Arrays.fill(copy[i], 0);
			}
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(arr[i][j] <= water)
						copy[i][j] = -1;
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(copy[i][j] == 0 && !visit[i][j])
					{
						dfs(i, j);
						cnt++;
					}
			if(max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}
	private static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
			if(copy[nx][ny] == 0)
				dfs(nx, ny);
		}
	}
}