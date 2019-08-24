import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		int INF = 1000000000, max = 0;
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 0; i <= N; i++)
		{
			Arrays.fill(arr[i], INF);
//			arr[i][i] = 0;
		}
		arr[X][X] = 0;
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(arr[a][b] > c)
				arr[a][b] = c;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		for(int i = 1; i <= N; i++)
		{
			if(arr[i][X] + arr[X][i] > max)
				max = arr[i][X] + arr[X][i]; 
		}
		System.out.println(max);
	}
}