import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] a = new int[N][N], b = new int[N][N];
		
		int ar = 0, bc = 0, res = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				a[i][j] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				b[i][j] = sc.nextInt();
		
		while(ar < N)
		{
			int sum = 0;
			while(bc < N)
			{
				sum = 0;
				for(int i = 0; i < N; i++)
					sum += (a[ar][i] * b[i][bc]);
//				System.out.print(sum + " ");
				if(sum >= 1) res++;
				bc++;
			}
			bc = 0;
			ar++;
//			System.out.println();
		}
		System.out.println(res);
	}
}