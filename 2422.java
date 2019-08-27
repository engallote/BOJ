import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++)
			for(int j = i + 1; j <= N; j++)
				for(int k = j + 1; k <= N; k++)
					if(arr[i][j] + arr[i][k] + arr[j][k] == 0)
						cnt++;
		System.out.println(cnt);
	}
}