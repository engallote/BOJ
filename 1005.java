import java.util.*;

public class Main {
	static int N, W;
	static int[] inDgree, time;
	static ArrayList<ArrayList<Integer>> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			N = sc.nextInt();
			int K = sc.nextInt();
			inDgree = new int[N+1];
			time = new int[N+1];
			aly.clear();
			for(int i = 0; i <= N; i++)
				aly.add(new ArrayList<>());
			
			for(int i = 1; i <= N; i++)
				time[i] = sc.nextInt();
			
			for(int i = 0; i < K; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				aly.get(a).add(b);
				inDgree[b]++;
			}
			
			W = sc.nextInt();
			solve();
		}	
	}
	private static void solve() {
		int[] max = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++)
			if(inDgree[i] == 0)
				q.offer(i);
		
		for(int i = 1; i <= N; i++)
		{
			if(q.isEmpty()) return;
			int x = q.poll();
			
			for(int j = 0; j < aly.get(x).size(); j++)
			{
				int y = aly.get(x).get(j);
				max[y] = Math.max(max[x] + time[x], max[y]);
				if(--inDgree[y] == 0)
					q.offer(y);
			}
		}
		
		System.out.println(max[W] + time[W]);
	}
}