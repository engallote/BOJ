import java.util.*;

public class Main {
	static int N, M, s, e, res = 0, cnt = 0;
	static boolean[] visit;
	static int[][] time;
	static int[] inDgree, arr;
	static ArrayList<ArrayList<Integer>> aly = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> back = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		inDgree = new int[N+1];
		time = new int[N+1][N+1];
		arr = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i = 0; i <= N; i++)
		{
			aly.add(new ArrayList<>());
			back.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			aly.get(a).add(b);
			back.get(b).add(a);
			inDgree[b]++;
			time[a][b] = w;
		}
		
		s = sc.nextInt();
		e = sc.nextInt();
		
		solve();
		solve2();
		System.out.println(arr[e]);
		System.out.println(cnt);
	}
	private static void solve2() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(e);
		
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int j = 0; j < back.get(x).size(); j++)
			{
				int y = back.get(x).get(j);
				if(arr[x] - arr[y] == time[y][x])
				{
//					System.out.println(x + " " + y);
					cnt++;
					if(!visit[y])//이미 방문했던 정점 다시 방문하지 않도록
					{
						visit[y] = true;
						q.offer(y);
					}
				}
			}
		}
	}
	private static void solve() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int j = 0; j < aly.get(x).size(); j++)
			{
				int y = aly.get(x).get(j);
				arr[y] = Math.max(arr[x] + time[x][y], arr[y]);
				if(--inDgree[y] == 0)
					q.offer(y);
			}
		}
		
//		for(int i = 1; i <= N; i++)
//			System.out.println(arr[i]);
	}
}