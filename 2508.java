import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			char[][] map = new char[N][M];
			boolean[][] visit = new boolean[N][M];
			for(int i = 0; i < N; i++)
				map[i] = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(j + 2 < M)
					{
						if(!visit[i][j] && !visit[i][j+1] && !visit[i][j+2])
						{
							if(map[i][j] == '>' && map[i][j+1] == 'o' && map[i][j+2] == '<')
							{
								visit[i][j] = true;
								visit[i][j+1] = true;
								visit[i][j+2] = true;
								cnt++;
							}
						}
					}
					if(i + 2 < N)
					{
						if(!visit[i][j] && !visit[i+1][j] && !visit[i+2][j])
						{
							if(map[i][j] == 'v' && map[i+1][j] == 'o' && map[i+2][j] == '^')
							{
								visit[i][j] = true;
								visit[i+1][j] = true;
								visit[i+2][j] = true;
								cnt++;
							}
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
}