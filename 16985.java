import java.util.*;

public class Main {
	static int res = Integer.MAX_VALUE;
	static int[] chk = new int[5];
	static int[][][] arr = new int[5][5][5];
	static int[][][][] maze = new int[5][4][5][5];
	static int[] dh = {1, -1, 0, 0, 0, 0}, dx = {0, 0, 1, 0, -1, 0}, dy = {0, 0, 0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int h = 0; h < 5; h++)
        {
        	int[][] tmp = new int[5][5];
        	for(int i = 0; i < 5; i++)
        		for(int j = 0; j < 5; j++)
        			tmp[i][j] = sc.nextInt();
        	make(h, tmp);
//        	System.out.println("------------------------");
        }
        
//        for(int h = 0; h < 4; h++)
//        {
//        	for(int i = 0; i < 5; i++)
//        	{
//        		for(int j = 0; j < 5; j++)
//        			System.out.print(maze[0][h][i][j] + " ");
//        		System.out.println();
//        	}
//        	System.out.println("///");
//        }

        Arrays.fill(chk, -1);
        int[] t = new int[5];
        Arrays.fill(t, -1);
        solve(0, 0, t);
        
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static void solve(int cnt, int visit, int[] t) {
		if(cnt == 5)
		{
			for(int h = 0; h < 5; h++)
			{
				for(int i = 0; i < 5; i++)
					for(int j = 0; j < 5; j++)
						arr[h][i][j] = maze[chk[h]][t[h]][i][j];
			}
			
			res = Math.min(res, bfs());
			return;
		}
		
		for(int i = 0; i < 5; i++)
			if((visit&(1<<i)) == 0)
			{
				chk[cnt] = i;
				for(int j = 0; j < 4; j++)
				{
					t[cnt] = j;
					solve(cnt + 1, visit|(1<<i), t);
					t[cnt] = -1;
				}
				chk[cnt] = -1;
			}
	}
	private static int bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[][][] visit = new boolean[5][5][5];
		if(arr[0][0][0] == 1 && arr[4][4][4] == 1)
		{
			pq.add(new Pair(0, 0, 0, 0));
			visit[0][0][0] = true;
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				if(p.h == 4 && p.x == 4 && p.y == 4)
				{
//					for(int h = 0; h < 5; h++)
//					{
//						for(int i = 0; i < 5; i++)
//						{
//							for(int j = 0; j < 5; j++)
//								System.out.print(arr[h][i][j] + " ");
//							System.out.println();
//						}
//						System.out.println("           ---           ");
//					}
//					System.out.println("//////////////////////");
					return p.cnt;
				}
				
				for(int i = 0; i < 6; i++)
				{
					int nh = p.h + dh[i], nx = p.x + dx[i], ny = p.y + dy[i];
					if(nh < 0 || nh >= 5 || nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nh][nx][ny] == 0 || visit[nh][nx][ny])
						continue;
					visit[nh][nx][ny] = true;
					pq.add(new Pair(nh, nx, ny, p.cnt + 1));
				}
			}
		}
		if(arr[0][4][0] == 1 && arr[4][0][4] == 1)
		{
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					Arrays.fill(visit[i][j], false);
			
			pq.add(new Pair(0, 4, 0, 0));
			visit[0][4][0] = true;
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				if(p.h == 4 && p.x == 0 && p.y == 4)
				{
//					for(int h = 0; h < 5; h++)
//					{
//						for(int i = 0; i < 5; i++)
//						{
//							for(int j = 0; j < 5; j++)
//								System.out.print(arr[h][i][j] + " ");
//							System.out.println();
//						}
//						System.out.println("           ---           ");
//					}
//					System.out.println("//////////////////////");
					return p.cnt;
				}
				
				for(int i = 0; i < 6; i++)
				{
					int nh = p.h + dh[i], nx = p.x + dx[i], ny = p.y + dy[i];
					if(nh < 0 || nh >= 5 || nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nh][nx][ny] == 0 ||  visit[nh][nx][ny])
						continue;
					visit[nh][nx][ny] = true;
					pq.add(new Pair(nh, nx, ny, p.cnt + 1));
				}
			}
		}
		if(arr[0][0][4] == 1 && arr[4][4][0] == 1)
		{
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					Arrays.fill(visit[i][j], false);
			
			pq.add(new Pair(0, 0, 4, 0));
			visit[0][0][4] = true;
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				if(p.h == 4 && p.x == 4 && p.y == 0)
				{
//					for(int h = 0; h < 5; h++)
//					{
//						for(int i = 0; i < 5; i++)
//						{
//							for(int j = 0; j < 5; j++)
//								System.out.print(arr[h][i][j] + " ");
//							System.out.println();
//						}
//						System.out.println("           ---           ");
//					}
//					System.out.println("//////////////////////");
					return p.cnt;
				}
				
				for(int i = 0; i < 6; i++)
				{
					int nh = p.h + dh[i], nx = p.x + dx[i], ny = p.y + dy[i];
					if(nh < 0 || nh >= 5 || nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nh][nx][ny] == 0 ||  visit[nh][nx][ny])
						continue;
					visit[nh][nx][ny] = true;
					pq.add(new Pair(nh, nx, ny, p.cnt + 1));
				}
			}
		}
		if(arr[0][4][4] == 1 && arr[4][0][0] == 1)
		{
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					Arrays.fill(visit[i][j], false);
			
			pq.add(new Pair(0, 4, 4, 0));
			visit[0][4][4] = true;
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				if(p.h == 4 && p.x == 0 && p.y == 0)
				{
//					for(int h = 0; h < 5; h++)
//					{
//						for(int i = 0; i < 5; i++)
//						{
//							for(int j = 0; j < 5; j++)
//								System.out.print(arr[h][i][j] + " ");
//							System.out.println();
//						}
//						System.out.println("           ---           ");
//					}
//					System.out.println("//////////////////////");
					return p.cnt;
				}
				
				for(int i = 0; i < 6; i++)
				{
					int nh = p.h + dh[i], nx = p.x + dx[i], ny = p.y + dy[i];
					if(nh < 0 || nh >= 5 || nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nh][nx][ny] == 0 ||  visit[nh][nx][ny])
						continue;
					visit[nh][nx][ny] = true;
					pq.add(new Pair(nh, nx, ny, p.cnt + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	private static void make(int h, int[][] tmp) {
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
//				System.out.println(i + " " + j);
				maze[h][0][i][j] = tmp[i][j];
			}
		
		int ii = 0, jj = 0;
		for(int j = 0; j < 5; j++)
			for(int i = 4; i >= 0; i--)
			{
				maze[h][1][ii][jj] = tmp[i][j];
				jj++;
				if(jj == 5)
				{
					ii++;
					jj = 0;
				}
			}
		
		ii = jj = 0;
		for(int i = 4; i >= 0; i--)
			for(int j = 4; j >= 0; j--)
			{
				maze[h][2][ii][jj] = tmp[i][j];
				jj++;
				if(jj == 5)
				{
					ii++;
					jj = 0;
				}
			}
		ii = jj = 0;
		for(int i = 0; i < 5; i++)
			for(int j = 4; j >= 0; j--)
			{
				maze[h][3][ii][jj] = tmp[i][j];
				ii++;
				if(ii == 5)
				{
					jj++;
					ii = 0;
				}
			}
	}
}
class Pair implements Comparable<Pair>{
	int h, x, y, cnt;
	Pair(int h, int x, int y, int cnt)
	{
		this.h = h;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}