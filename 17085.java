import java.util.*;

public class Main {
	static int N, M, res = 0;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Pair[] arr2 = new Pair[4];
	static char[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '#')
					solve(i, j);
		
		System.out.println(res);
	}
	private static void solve(int x, int y) {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		chk[x][y] = true;
		
		for(int i = 0; i < 4; i++) arr2[i] = new Pair(x, y);
		
		boolean flag = true;
		int cnt = 1, tmp = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '#' && !chk[i][j])
					tmp = Math.max(tmp, solve2(i, j));
		res = Math.max(res, cnt * tmp);
		
		while(flag)
		{
			for(int i = 0; i < 4; i++)
			{
				int nx = arr2[i].x + dx[i], ny = arr2[i].y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.')
				{
					flag = false;
					break;
				}
				chk[nx][ny] = true;
				arr2[i].x = nx;
				arr2[i].y = ny;
			}
			if(flag)
			{
				tmp = 0;
				cnt += 4;
				for(int i = 0; i < N; i++)
					for(int j = 0; j < M; j++)
						if(arr[i][j] == '#' && !chk[i][j])
							tmp = Math.max(tmp, solve2(i, j));
				res = Math.max(res, cnt * tmp);
			}
		}
	}
	private static int solve2(int x, int y) {
		boolean flag = true;
		int cnt = 1;
		Pair[] tmp = new Pair[4];
		for(int i = 0; i < 4; i++) tmp[i] = new Pair(x, y);
		
		while(flag)
		{
			for(int i = 0; i < 4; i++)
			{
				int nx = tmp[i].x + dx[i], ny = tmp[i].y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.' || chk[nx][ny])
				{
					flag = false;
					break;
				}
				tmp[i].x = nx;
				tmp[i].y = ny;
			}
			if(flag) cnt += 4;
		}
		return cnt;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}