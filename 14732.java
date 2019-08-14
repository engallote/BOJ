import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[501][501];
		int res = 0;
		for(int t = 0; t < N; t++)
		{
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			
			for(int i = sx; i < ex; i++)
				for(int j = sy; j < ey; j++)
					if(arr[i][j] == 0)
					{
						res++;
						arr[i][j]++;
					}
		}
		
//		for(int i = 0; i <= 10; i++)
//		{
//			for(int j = 0; j <= 10; j++)
//				System.out.print(arr[i][j] + " ");
//			System.out.println();
//		}
		System.out.println(res);
	}
}