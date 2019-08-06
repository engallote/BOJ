import java.util.*;
 
public class Main {
    static int N, M, res;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static ArrayList<Pair> virus = new ArrayList<>(), empty = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        res = 0;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		if(arr[i][j] == 2)
        			virus.add(new Pair(i, j));
        		else if(arr[i][j] == 0)
        			empty.add(new Pair(i, j));
        	}
        
        solve(0, 0);
        System.out.println(res);
    }
	private static void solve(int idx, int cnt) {
		if(cnt == 3)
		{
			int[][] tmp = new int[N][M];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					tmp[i][j] = arr[i][j];
			spread(tmp);
			res = Math.max(res, findSafeArea(tmp));
			return;
		}
		if(idx == empty.size()) return;
		arr[empty.get(idx).x][empty.get(idx).y] = 1;
		solve(idx + 1, cnt + 1);
		arr[empty.get(idx).x][empty.get(idx).y] = 0;
		solve(idx + 1, cnt);
	}
	private static int findSafeArea(int[][] tmp) {
		int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(tmp[i][j] == 0) cnt++;
		return cnt;
	}
	private static void spread(int[][] tmp) {
		Queue<Pair> q = new LinkedList<>();
		for(Pair v : virus)
		{
			q.add(v);
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || tmp[nx][ny] != 0) continue;
					tmp[nx][ny] = 2;
					q.add(new Pair(nx, ny));
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