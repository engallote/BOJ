import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for(int i = 0; i <= N; i++)
			Arrays.fill(arr[i], 10000000);
		
		for(int i = 0; i < m; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = arr[y][x] = 1;
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
		System.out.println(arr[a][b] == 10000000 ? -1 : arr[a][b]);
	}
}