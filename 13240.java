import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean flag = true;
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(j == 0 && i - 1 >= 0)
				{
					if(arr[i-1][j] == 0)
					{
						flag = true;
						arr[i][j] = 1;
					}
					else
					{
						flag = false;
						arr[i][j] = 0;
					}
				}
				arr[i][j] = flag ? 1 : 0;
				System.out.print(flag ? "*" : ".");
				flag = !flag;
				
			}
			System.out.println();
		}
	}
}