import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 0; i < R; i++)
		{
			int num = sc.nextInt();
			if(num == 1) reverseV();
			else if(num == 2) reverseH();
			else if(num == 3) rotateR();
			else if(num == 4) rotateL();
			else if(num == 5) changeR();
			else if(num == 6) changeL();
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	private static void changeL() {
		int[][] tmp = new int[N/2][M/2];
		int r = 0, c = M / 2;
		for(int i = 0; i < N / 2; i++)
		{
			for(int j = 0; j < M / 2; j++)
			{
				tmp[i][j] = arr[i][j];
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = M / 2;
		}
		
		r = N / 2;
		c = M / 2;
		for(int i = 0; i < N / 2; i++)
		{
			for(int j = M / 2; j < M; j++)
			{
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = M / 2;
		}
		
		r = N / 2;
		c = 0;
		for(int i = N / 2; i < N; i++)
		{
			for(int j = M / 2; j < M; j++)
			{
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = 0;
		}
		
		r = c = 0;
		for(int i = N / 2; i < N; i++)
		{
			for(int j = 0; j < M / 2; j++)
			{
				arr[i][j] = tmp[r][c];
				c++;
			}
			r++;
			c = 0;
		}
	}
	private static void changeR() {
		int[][] tmp = new int[N/2][M/2];
		int r = N / 2, c = 0;
		for(int i = 0; i < N / 2; i++)
		{
			for(int j = 0; j < M / 2; j++)
			{
				tmp[i][j] = arr[i][j];
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = 0;
		}
		r = N / 2;
		c = M / 2;
		for(int i = N / 2; i < N; i++)
		{
			for(int j = 0; j < M / 2; j++)
			{
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = M / 2;
		}
		
		r = 0;
		c = M / 2;
		for(int i = N / 2; i < N; i++)
		{
			for(int j = M / 2; j < M; j++)
			{
				arr[i][j] = arr[r][c];
				c++;
			}
			r++;
			c = M / 2;
		}
		
		r = c = 0;
		for(int i = 0; i < N / 2; i++)
		{
			for(int j = M / 2; j < M; j++)
			{
				arr[i][j] = tmp[r][c];
				c++;
			}
			r++;
			c = 0;
		}
	}
	private static void rotateL() {
		int[][] tmp = new int[M][N];
		
		int r = M - 1, c = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				tmp[r][c] = arr[i][j];
				r--;
				if(r < 0)
				{
					r = M - 1;
					c++;
				}
			}
		}
		arr = new int[M][N];
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = tmp[i][j];
		int tmp2 = N;
		N = M;
		M = tmp2;
	}
	private static void rotateR() {
		int[][] tmp = new int[M][N];
		
		int r = 0, c = N - 1;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				tmp[r][c] = arr[i][j];
				r++;
				if(r == M)
				{
					r = 0;
					c--;
				}
			}
		}
		arr = new int[M][N];
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = tmp[i][j];
		int tmp2 = M;
		M = N;
		N = tmp2;
	}
	private static void reverseH() {
		for(int i = 0; i < N; i++)
		{
			int l = 0, r = M - 1;
			while(l <= r)
			{
				int tmp = arr[i][l];
				arr[i][l] = arr[i][r];
				arr[i][r] = tmp;
				l++;
				r--;
			}
		}
	}
	private static void reverseV() {
		for(int i = 0; i < M; i++)
		{
			int l = 0, r = N - 1;
			while(l <= r)
			{
				int tmp = arr[l][i];
				arr[l][i] = arr[r][i];
				arr[r][i] = tmp;
				l++;
				r--;
			}
		}
	}
}