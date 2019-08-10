import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//별 = 4, 동그라미 = 3, 네모 = 2, 세모 = 1
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			int[][] arr = new int[2][5];
			int num = sc.nextInt();
			for(int j = 0; j < num; j++)
				arr[0][sc.nextInt()]++;
			num = sc.nextInt();
			for(int j = 0; j < num; j++)
				arr[1][sc.nextInt()]++;
			
			int flag = 0;
			for(int k = 4; k >= 1; k--)
			{
				if(arr[0][k] > arr[1][k])
				{
					flag = 1;
					break;
				}
				else if(arr[0][k] < arr[1][k])
				{
					flag = 2;
					break;
				}
			}
			
			if(flag == 1)
				System.out.println("A");
			else if(flag == 2)
				System.out.println("B");
			else
				System.out.println("D");
		}
	}
}