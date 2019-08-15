import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		for(int i = 0; i < 5; i++) 
		{
			Arrays.fill(arr[i], 10000000);
			arr[i][i] = 0;
		}
		
		for(int i = 1; i < 5; i++)
		{
			arr[i-1][i] = sc.nextInt();
			arr[i][i-1] = arr[i-1][i];
		}
		
		for(int k = 0; k < 5; k++)
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
					
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}