import java.util.*;

public class Main {
	static int N, count = 0;
	static boolean[][] visit;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = 0;
		arr = new int[N][N];
		visit = new boolean[N][N];
		Vector<Integer> res = new Vector<>();
		for(int i = 0; i < N; i++)
		{
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				arr[i][j] = ch[j]-'0';
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(arr[i][j] == 1 && !visit[i][j])
				{
					count = 0;
					dfs(i, j);
					res.add(count);
					cnt++;
				}
		res.sort(null);
		System.out.println(cnt);
		for(int i : res)
			System.out.println(i);
	}
	private static void dfs(int x, int y) {
		count++;
		visit[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
			else if(arr[nx][ny] == 1)
				dfs(nx, ny);
		}
	}
}