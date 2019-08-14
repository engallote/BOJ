import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = N * (N * N + 1) / 2;
		int[] number = new int[N*N+1];
		int[][] arr = new int[N][N], hor = new int[N][N], ver = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				number[arr[i][j]]++;
				hor[i][j] = arr[i][j];
				ver[i][j] = arr[i][j];
				if(j - 1 >= 0) ver[i][j] += ver[i][j-1];
				if(i - 1 >= 0) hor[i][j] += hor[i-1][j];
			}
		
		boolean flag = true;
		for(int i = 0; i < N; i++)
			if(ver[i][N-1] != num || hor[N-1][i] != num)
			{
				flag = false;
				break;
			}
		if(!flag)
		{
			System.out.println("FALSE");
			return;
		}
		int sum1 = 0, sum2 = 0, idx1 = 0, idx2 = N - 1;
		for(int i = 0; i < N; i++)
		{
			sum1 += arr[i][idx1];
			sum2 += arr[i][idx2];
			idx1++;
			idx2--;
		}
		if(sum1 != num || sum2 != num)
		{
			System.out.println("FALSE");
			return;
		}
		for(int i = 1; i <= N * N; i++)
			if(number[i] != 1)
			{
				System.out.println("FALSE");
				return;
			}
		System.out.println("TRUE");
	}
}