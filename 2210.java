import java.util.*;

public class Main {
	static int[][] arr = new int[5][5];
	static boolean[][][] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				visit = new boolean[5][5][7];
				solve(i, j, arr[i][j]+"");
			}
		System.out.println(hs.size());
	}
	private static void solve(int x, int y, String s) {
		if(s.length() == 6)
		{
			hs.add(s);
			return;
		}
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visit[nx][ny][s.length()]) continue;
			solve(nx, ny, s+arr[nx][ny]);
		}
	}
}