import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[] num;
	static char[][] arr;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new int[N][M];
		num = new int[1000000];
		int idx = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(chk[i], -1);
			arr[i] = sc.next().toCharArray();
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '0' && chk[i][j] == -1)
				{
					cnt = 0;
					dfs(i, j, idx);
					num[idx] = cnt;
					idx++;
				}
		
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == '1')
				{
					int sum = 1;
					hs.clear();
					for(int k = 0; k < 4; k++)
					{
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] == -1) continue;
						if(hs.contains(chk[nx][ny])) continue;
						hs.add(chk[nx][ny]);
						sum += num[chk[nx][ny]];
					}
					System.out.print(sum%10);
				}
				else System.out.print(0);
			}
			System.out.println();
		}
	}
	private static void dfs(int x, int y, int idx) {
		chk[x][y] = idx;
		cnt++;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] != -1 || arr[nx][ny] == '1')
				continue;
			dfs(nx, ny, idx);
		}
	}
}