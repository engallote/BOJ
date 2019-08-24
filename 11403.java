import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0)
					arr[i][j] = 100000000;
			}
		
		
		for(int k = 0; k < N; k++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				System.out.print((arr[i][j] == 100000000 ? 0 : 1) + " ");
			System.out.println();
		}
	}
}