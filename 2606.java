import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N+1];
		arr = new int[N+1][N+1];
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		int cnt = 0;
		while(!q.isEmpty())
		{
			int num = q.poll();
			if(!visit[num]) cnt++;
			visit[num] = true;
			for(int i = 1; i <= N; i++)
			{
				if(arr[num][i] != 0 && !visit[i])
					q.offer(i);
			}
		}
		
		System.out.println(cnt-1);
	}
}