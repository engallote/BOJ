import java.util.*;

public class Main {
	static int N, M;
	static long[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N;
		
		arr = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextLong();
		
		while(N != 1 && M != 1)
		{
			hor();
			ver();
		}
		System.out.println(arr[0][0]);
	}
	private static void ver() {
		long[][] tmp = new long[N/2][M];
		int row = N/2;
		for(int i = 0; i < N/2; i++)
		{
			for(int j = 0; j < M; j++)
			{
				tmp[i][j] = arr[i][j] + arr[row][j];
			}
			row++;
		}
		N/=2;
		arr = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = tmp[i][j];
	}
	private static void hor() {
		long[][] tmp = new long[N][M/2];
		int col = M/2;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M / 2; j++)
			{
				tmp[i][j] = arr[i][j] + arr[i][col];
				col++;
			}
			col = M/2;
		}
		M/=2;
		arr = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = tmp[i][j];
	}
}