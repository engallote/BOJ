import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N == 0 && M == 0) break;
			int res = 0;
			int[][] arr = new int[N][M];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
				{
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 0) continue;
					else if(i != 0 && j != 0)
						arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i-1][j-1], arr[i][j-1])) + 1;
					res = Math.max(res, arr[i][j]);
				}
			
			System.out.println(res);
		}
	}
}