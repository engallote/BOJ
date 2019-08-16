import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] arr = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = true;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] && arr[k][j]) arr[i][j] = true;
		
		int k = sc.nextInt();
		for(int i = 0; i < k; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(arr[a][b]) System.out.println(-1);
			else if(arr[b][a]) System.out.println(1);
			else System.out.println(0);
		}
	}
}