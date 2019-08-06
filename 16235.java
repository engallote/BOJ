import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		int[][] arr = new int[N][N];
		int[][] plus = new int[N][N];
		PriorityQueue<Integer>[][] pq = new PriorityQueue[N][N];
		for(int i = 0; i < N; i++)
		{
			pq[i] = new PriorityQueue[N];
			for(int j = 0; j < N; j++)
			{
				pq[i][j] = new PriorityQueue<>();
				plus[i][j] = sc.nextInt();
				arr[i][j] = 5;
			}
		}
		
		for(int i = 0; i < M; i++)
		{
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int k = sc.nextInt();
			pq[x][y].add(k);
		}
		
		Queue<Pair> dead = new LinkedList<>(), alive = new LinkedList<>();
		for(int k = 0; k < K; k++)
		{
			//spring
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
				{
					while(!pq[i][j].isEmpty())
					{
						int tree = pq[i][j].poll();
						
						if(arr[i][j] >= tree)
						{
							arr[i][j] -= tree;
							alive.add(new Pair(i, j, tree + 1));
						}
						else
							dead.add(new Pair(i, j, tree));
					}
				}
			
			//summer
			while(!dead.isEmpty())
			{
				Pair p = dead.poll();
				
				int tree = (int)Math.floor(p.k / 2);
				arr[p.x][p.y] += tree;
			}
			
			//fall
			while(!alive.isEmpty())
			{
				Pair p = alive.poll();
				pq[p.x][p.y].add(p.k);
				if(p.k % 5 == 0)//5¹è¼ö
				{
					for(int i = 0; i < 8; i++)
					{
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						pq[nx][ny].add(1);
					}
				}
			}
			
			//winter
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] += plus[i][j];
		}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				res += pq[i][j].size();
				
		System.out.println(res);
	}
}
class Pair{
	int x, y, k;
	Pair(int x, int y, int k)
	{
		this.x = x;
		this.y = y;
		this.k = k;
	}
}