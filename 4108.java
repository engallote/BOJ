import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		while(true)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N == 0 && M == 0) break;
			
			char[][] arr = new char[N][M];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(arr[i][j] == '.')
					{
						int cnt = 0;
						for(int k = 0; k < 8; k++)
						{
							int nx = i + dx[k], ny = j + dy[k];
							if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != '*') continue;
							cnt++;
						}
						arr[i][j] = (char)(cnt+'0');
					}
				}
			}
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
		}
	}
}