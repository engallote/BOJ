import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		
		for(int t = 0; t < 4; t++)
		{
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int i = x1 + 1; i <= x2; i++)
				for(int j = y1 + 1; j <= y2; j++)
					arr[i][j] = 1;
		}
		
		int res = 0;
		for(int i = 1; i <= 100; i++)
		{
			for(int j = 1; j <= 100; j++)
			{
				if(arr[i][j] == 1) res++;
//				System.out.print(arr[i][j]);
			}
//			System.out.println();
		}
		
		System.out.println(res);
	}
}