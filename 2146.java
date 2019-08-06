import java.util.*;

public class Main {
	static int N;
	static boolean end;
	static int[][] chk, arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        chk = new int[N][N];
        int cnt = 1;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		arr[i][j] = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(arr[i][j] == 1 && chk[i][j] == 0)
        		{
        			dfs(i, j, cnt);
        			cnt++;
        		}
        boolean flag = true;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(arr[i][j] == 1)
        		{
        			flag = false;
        			for(int k = 0; k < 4; k++)
        			{
        				int nx = i + dx[k], ny = j + dy[k];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= N)
        					continue;
        				if(arr[nx][ny] == 0)
        				{
        					flag = true;
        					break;
        				}
        			}
        			if(flag) q.add(new Pair(i, j, chk[i][j]));
        		}
        
        boolean[][] visit = new boolean[N][N];
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
        	Pair pair = q.poll();
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	pq.add(new Pair(pair.x, pair.y, pair.num, 0));
        	visit[pair.x][pair.y] = true;
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		
        		if(arr[p.x][p.y] == 1 && p.num != chk[p.x][p.y])
        		{
        			res = Math.min(res, p.cnt - 1);
        			break;
        		}
        		
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || chk[nx][ny] == p.num) continue;
        			visit[nx][ny] = true;
        			pq.add(new Pair(nx, ny, p.num, p.cnt + 1));
        		}
        	}
        	
        	for(int i = 0; i < N; i++)
        		Arrays.fill(visit[i], false);
        }
        
        System.out.println(res);
	}
	private static void dfs(int x, int y, int num) {
		chk[x][y] = num;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 0 || chk[nx][ny] != 0)
				continue;
			dfs(nx, ny, num);
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, num, cnt;
	Pair(int x, int y, int num)
	{
		this.x = x;
		this.y = y;
		this.num = num;
	}
	Pair(int x, int y, int num, int cnt)
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}