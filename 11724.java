import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr= new int[N+1][N+1];
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		boolean[] visit = new boolean[N+1];
		
		int cnt = 0;
		for(int i = 1; i <= N; i++)
		{
			if(visit[i]) continue;
			cnt++;
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			visit[i] = true;
			
			while(!q.isEmpty())
			{
				int x = q.poll();
				
				for(int j = 1; j <= N; j++)
					if(arr[x][j] == 1 && !visit[j])
					{
						visit[j] = true;
						q.offer(j);
					}
			}
		}
		
		System.out.println(cnt);
	}
}