import java.util.*;

public class Main {
	static int N, M, V;
	static Vector<Integer> b = new Vector<>(), d = new Vector<>();
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		
		while(!q.isEmpty())
		{
			int num = q.poll();
			if(!b.contains(num))
				b.add(num);
			visit[num] = true;
			
			for(int i = 1; i <= N; i++)
				if(arr[num][i] == 1 && !visit[i])
					q.add(i);	
		}
		
		Arrays.fill(visit, false);
		dfs(V);
		
		for(int i : d)
			System.out.print(i + " ");
		System.out.println();
		for(int i : b)
			System.out.print(i + " ");
	}
	private static void dfs(int v) {
		int cnt = 0;
		for(int i = 1; i <= N; i++)
			if(visit[i]) cnt++;
		if(cnt == N) return;
		d.add(v);
		visit[v] = true;
		for(int i = 1; i <= N; i++)
			if(arr[v][i] == 1 && !visit[i])
				dfs(i);
	}
}