import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(arr[i], 1000000000);
			arr[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(c == 0)
			{
				arr[a][b] = 0;
				arr[b][a] = 1;
			}
			else
				arr[a][b] = arr[b][a] = 0;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
					{
						arr[i][j] = arr[i][k] + arr[k][j];
					}
		
		int k = sc.nextInt();
		for(int i = 0; i < k; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[a][b]);
		}
	}
}