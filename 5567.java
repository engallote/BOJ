import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		arr = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
			if(a == 1 || b == 1)
			{
				q.add(Math.max(a, b));
				visit[Math.max(a, b)] = true;
			}
		}
		cnt = q.size();
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int i = 2; i <= N; i++)
				if(arr[x][i] == 1 && !visit[i])
				{
					visit[i] = true;
					cnt++;
				}
		}
		System.out.println(cnt);
	}
}
