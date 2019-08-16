import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        chk = new boolean[N][M];
        res = 0;
        int max = 0;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		max = Math.max(max, arr[i][j]);
        	}
        
        for(int k = 1; k < max; k++)
        {
        	for(int i = 0; i < N; i++)
        		Arrays.fill(chk[i], false);
        	
        	for(int i = 1; i < N - 1; i++)
        		for(int j = 1; j < M - 1; j++)
        			if(arr[i][j] == k && !chk[i][j])
        			{
        				bfs(i, j, k);
        			}
        }
        System.out.println(res);
	}
	private static void bfs(int x, int y, int k) {
		Queue<Pair> q = new LinkedList<>(), tmp = new LinkedList<>();
		q.add(new Pair(x, y));
		chk[x][y] = true;
		boolean flag = false;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			tmp.add(p);
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != k || chk[nx][ny]) continue;
				chk[nx][ny] = true;
				if(nx == 0 || ny == 0 || nx == N - 1 || ny == M - 1)
					flag = true;
				q.add(new Pair(nx, ny));
			}
		}
		
		if(flag) return;
		int h = Integer.MAX_VALUE;
		q.clear();
		while(!tmp.isEmpty())
		{
			Pair p = tmp.poll();
			q.add(p);
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				h = Math.min(h, arr[nx][ny]);
			}
		}
		
		if(h > k)
		{
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				
				if(arr[p.x][p.y] < h)
				{
					res += h - arr[p.x][p.y];
					arr[p.x][p.y] = h;
				}
			}
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