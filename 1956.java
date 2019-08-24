import java.util.*;

public class Main {
	static int V, min, INF = 1000000000;
	static int[][] time;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		min = INF;
		time = new int[V+1][V+1];
		visit = new boolean[V+1];
		for(int i = 0; i <= V; i++)
		{
			Arrays.fill(time[i], INF);
			time[i][i] = 0;
		}
		for(int i = 0; i < E; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			time[a][b] = c;
		}
		
		for(int k = 1; k <= V; k++)
			for(int i = 1; i <= V; i++)
				for(int j = 1; j <= V; j++)
					if(time[i][k] + time[k][j] < time[i][j])
						time[i][j] = time[i][k] + time[k][j];
			
		for(int i = 1; i <= V; i++)
		{
			int sum = 0;
			for(int j = 1; j <= V; j++)
			{
				if(i != j)
				{
					sum = time[i][j] + time[j][i];
					min = Math.min(min, sum);
				}
			}
		}
		System.out.println(min == INF ? -1 : min);
	}
}