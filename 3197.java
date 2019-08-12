import java.util.*;
 
public class Main {
    static int N, M;
    static int[][] arr;
    static boolean end;
    static boolean[][] chk, chk2;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static Pair f, s;
    static Queue<Pair> water = new LinkedList<>(), q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        chk = new boolean[N][M];
        chk2 = new boolean[N][M];
        boolean first = false;
        for(int i = 0; i < N; i++)
        {
        	char[] c = sc.next().toCharArray();
        	for(int j = 0; j < M; j++)
        	{
        		if(c[j] == 'L')
        		{
        			chk[i][j] = true;
        			water.add(new Pair(i, j));
        			if(!first)
        			{
        				chk2[i][j] = true;
        				f = new Pair(i, j);
        				first = true;
        			}
        			else s = new Pair(i, j);
        		}
        		else if(c[j] == 'X') arr[i][j] = -1;
        		else
        		{
        			chk[i][j] = true;
        			water.add(new Pair(i, j));
        		}
        	}
        }
        end = false;
        dfs(f.x, f.y);
        if(end)
        {
        	System.out.println(0);
        	return;
        }
        int time = 0;
        
        while(!end)
        {
        	int size = water.size();
        	
        	for(int k = 0; k < size; k++)
        	{
        		Pair p = water.poll();
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] != -1) continue;
        			chk[nx][ny] = true;
    				arr[nx][ny] = 0;
    				water.add(new Pair(nx, ny));
        		}
        	}
        	size = q.size();
        	for(int k = 0; k < size; k++)
        	{
        		Pair p = q.poll();
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk2[nx][ny] || arr[nx][ny] == -1) continue;
        			chk2[nx][ny] = true;
        			dfs(nx, ny);
//        			q.add(new Pair(nx, ny));
        		}
        	}
        	time++;
        }    
        System.out.println(time);
    }
	private static void dfs(int x, int y) {
		q.add(new Pair(x, y));
		if(x == s.x && y == s.y) 
		{
			end = true;
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk2[nx][ny] || arr[nx][ny] == -1)
				continue;
			chk2[nx][ny] = true;
			dfs(nx, ny);
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