import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		for(int i = 0; i <= N; i++)
			Arrays.fill(arr[i], 1000000000);
		
		for(int i = 0; i < N-1; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a][b] = arr[b][a] = Math.min(arr[a][b], c);
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
//		for(int i = 1; i <= N; i++)
//		{
//			for(int j = 1; j <= N; j++)
//				System.out.print(arr[i][j]+ " ");
//			System.out.println();
//		}
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(arr[a][b]);
		}
	}
}