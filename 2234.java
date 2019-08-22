import java.util.*;

public class Main {
	static int N, M, room = 0, max1 = 0, tmp = 0, max2 = 0;
	static int[] dx = {0, 0, 0, 1, -1}, dy = {0, 1, -1, 0, 0};
	static boolean[][] visit, visit2;
	static boolean[][][] wall;
	static int[][] arr;
	static int[] w = new int[2501];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		visit = new boolean[N][M];
		visit2 = new boolean[N][M];
		wall = new boolean[N][M][5];//1은 동, 2는 서, 3은 남, 4는 북
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				int num = sc.nextInt();
				
				if(num - 8 >= 0)//남벽
				{
					num -= 8;
					wall[i][j][3] = true;
				}
				if(num - 4 >= 0)//동벽
				{
					num -= 4;
					wall[i][j][1] = true;
				}
				if(num - 2 >= 0)//북벽
				{
					num -= 2;
					wall[i][j][4] = true;
				}
				if(num - 1 >= 0)//서벽
				{
					num -= 1;
					wall[i][j][2] = true;
				}
			}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(!visit[i][j])
				{
					room++;
					tmp = 0;
					find(i, j);
					w[room] = tmp;
					max1 = Math.max(max1, tmp);
				}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				for(int k = 1; k <= 4; k++)
				{
					int nx = i + dx[k], ny = j + dy[k];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit2[nx][ny]) continue;
					if(arr[nx][ny] != arr[i][j])
						max2 = Math.max(max2, w[arr[i][j]] + w[arr[nx][ny]]);
					else visit2[nx][ny] = true;
				}
			}
		
		System.out.println(room);
		System.out.println(max1);
		System.out.println(max2);
	}
	private static void find(int x, int y) {
		tmp++;
		visit[x][y] = true;
		arr[x][y] = room;
		for(int i = 1; i <= 4; i++)
		{
			if(wall[x][y][i]) continue;
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
			find(nx, ny);
		}
	}
}