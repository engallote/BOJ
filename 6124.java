import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		int[][] sum = new int[N+1][M+1];
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++)
			{
				arr[i][j] = sc.nextInt();
				arr[i][j] += arr[i][j-1];
			}
		
		int row = Integer.MAX_VALUE, col = 0, max = 0;
		for(int i = 1; i <= N - 2; i++)
		{
			for(int j = 1; j <= M - 2; j++)
			{
				sum[i][j] += (arr[i][j+2] - arr[i][j-1]);
				sum[i][j] += (arr[i+1][j+2] - arr[i+1][j-1]);
				sum[i][j] += (arr[i+2][j+2] - arr[i+2][j-1]);
				if(sum[i][j] > max)
				{
					max = sum[i][j];
					row = i;
					col = j;
				}
				else if(sum[i][j] == max && row > i)
				{
					row = i;
					col = j;
				}
				else if(sum[i][j] == max && row == i && col > j) col = j;
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
//		for(int i = 1; i <= N; i++)
//		{
//			for(int j = 1; j <= M; j++)
//				System.out.print(sum[i][j] + " ");
//			System.out.println();
//		}
	}
}