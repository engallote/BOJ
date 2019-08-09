import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int INF = 1000;
		int cnt = 0;
		int[][] arr = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
//		for(int i = 1; i <= N; i++)
//		{
//			for(int j = 1; j <= N; j++)
//				System.out.print(arr[i][j] + " ");
//			System.out.println();
//		}
		Vector<Integer> v = new Vector<>();
		for(int i = 1; i <= N; i++)
		{
			if(visit[i]) continue;
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			visit[i] = true;
			int min = INF, num = i;
			while(!q.isEmpty())
			{
				int x = q.poll();
				int max = 0;
				for(int j = 1; j <= N; j++)
				{
					if(arr[x][j] != 0 && arr[x][j] != INF)
					{
						max = Math.max(max, arr[x][j]);
						if(!visit[j])
						{
							q.offer(j);
							visit[j] = true;
						}
					}
				}
				if(min > max)
				{
					min = max;
					num = x;
				}
			}
			v.add(num);
			cnt++;
		}
		v.sort(null);
		System.out.println(cnt);
		for(int i : v)
			System.out.println(i);
	}
}
//���� : https://www.acmicpc.net/board/view/16286