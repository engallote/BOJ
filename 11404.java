import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int INF = 1000000000;
		long[][] path = new long[N+1][N+1];
		
		for(int i = 0; i <= N; i++)
		{
			Arrays.fill(path[i], INF);
			path[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			path[a][b] = Math.min(path[a][b], c);
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(path[i][k] + path[k][j] < path[i][j])
					{
						path[i][j] = path[i][k] + path[k][j];
					}
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
				System.out.print((path[i][j] == INF ? "0 " : path[i][j] + " "));
			
			System.out.println();
		}
	}
}