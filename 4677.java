import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, -1, 1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	if(N == 0 && M == 0) break;
        	
        	int res = 0;
        	arr = new char[N][M];
        	chk = new boolean[N][M];
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.next().toCharArray();
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        			if(arr[i][j] == '@' && !chk[i][j])
        			{
        				res++;
        				dfs(i, j);
        			}
        	System.out.println(res);
        }
	}
	private static void dfs(int x, int y) {
		chk[x][y] = true;
		
		for(int i = 0; i < 8; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '*' || chk[nx][ny]) continue;
			dfs(nx, ny);
		}
	}
}