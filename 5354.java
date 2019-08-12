import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			char[][] arr = new char[N][N];
			for(int i = 0; i < N; i++)
			{
				Arrays.fill(arr[i], '#');
				for(int j = 1; j < N - 1; j++)
					if(i > 0 && i < N - 1) arr[i][j] = 'J';
			}
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
			System.out.println();
		}
	}
}