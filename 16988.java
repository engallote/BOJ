import java.util.*;

public class Main {
	static int N, M, res, cnt, num;
	static int[][] arr;
	static int[][] chk;
	static ArrayList<Pair>[] ene = new ArrayList[3];
	static ArrayList<Pair> q = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        chk = new int[N][M];
        
        for(int i = 1; i <= 2; i++)
        	ene[i] = new ArrayList<>();
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		arr[i][j] = sc.nextInt();
        
        int start = 1;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		if(arr[i][j] == 2 && chk[i][j] == 0)
        		{
        			q = new ArrayList<>();
        			num = 0;
        			cnt = 0;
        			dfs(i, j, start);
//        			System.out.println("=======");
        			if(cnt <= 2)
        				ene[cnt].add(new Pair(i, j, q, num));
        			start++;
//        			for(Pair k : q)
//        				System.out.println(k.x + ", " + k.y);
        		}
        res = 0;
        //주변에 빈칸이 1개인 지점 먼저 찾기
        for(int i = 0; i < ene[1].size(); i++)
        {
        	Pair p = ene[1].get(i);
        	arr[p.q.get(0).x][p.q.get(0).y] = 1;
    		for(int j = i + 1; j < ene[1].size(); j++)
    		{
    			Pair p2 = ene[1].get(j);
    			if(p2.x == p.x && p2.y == p.y) continue;
    			arr[p2.q.get(0).x][p2.q.get(0).y] = 1;
    			
    			res = Math.max(res, find());
    			
    			arr[p2.q.get(0).x][p2.q.get(0).y] = 0;
    		}
    		res = Math.max(res, find());
    		arr[p.q.get(0).x][p.q.get(0).y] = 0;
        }
        //주변에 빈칸이 2개인 지점 먼저 찾기
        for(int i = 0; i < ene[2].size(); i++)
        {
//        	for(Pair k : ene[2].get(i).q)
//        		System.out.println(k.x + " " + k.y);
        	Pair p = ene[2].get(i).q.get(0), p2 = ene[2].get(i).q.get(1);
//        	System.out.println(p.x + " " + p.y + ", " + p2.x + " " + p2.y);
        	arr[p.x][p.y] = arr[p2.x][p2.y] = 1;
        	
        	res = Math.max(res, find());
        	
        	arr[p.x][p.y] = arr[p2.x][p2.y] = 0;
        }
        System.out.println(res);
	}
	private static int find() {
		int sum = 0;
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 2 && !visit[i][j])
				{
					sum += bfs(i, j, visit);
				}
		return sum;
	}
	private static int bfs(int x, int y, boolean[][] visit) {
		int count = 0;
		boolean flag = true;
		visit[x][y] = true;
		Queue<Pair> qq = new LinkedList<>();
		qq.add(new Pair(x, y));
		
		while(!qq.isEmpty())
		{
			Pair p = qq.poll();
			count++;
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || visit[nx][ny])
					continue;
				if(arr[nx][ny] == 0) flag = false;
				else
				{
					visit[nx][ny] = true;
					qq.add(new Pair(nx, ny));
				}
			}
		}
		if(flag) return count;
		else return 0;
	}
	private static void dfs(int x, int y, int n) {
		chk[x][y] = n;
		num++;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || chk[nx][ny] == n) continue;
			if(arr[nx][ny] == 0 && chk[nx][ny] != n)
			{
				chk[nx][ny] = n;
//				System.out.println(nx + " " + ny);
				q.add(new Pair(nx, ny));
				cnt++;
			}
			else dfs(nx, ny, n);
		}
	}
}
class Pair{
	int x, y, cnt, num;
	ArrayList<Pair> q;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, ArrayList<Pair> q, int num)
	{
		this.x = x;
		this.y = y;
		this.q = q;
		this.num = num;
	}
}