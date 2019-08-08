import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					arr[i][j] = sc.nextInt();
					
			int res = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(arr[i][j] == 0) continue;
					int sum = 0;
					for(int k = i; k < N; k++)
						if(arr[k][j] == 0) sum++;
					res += sum;
				}
			}
			System.out.println(res);
		}
	}
}