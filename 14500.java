import java.util.*;

public class Main {
	static int N, M, res = 0;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		arr[i][j] = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        	{
        		solve(i, j);
        	}
        System.out.println(res);
    }
	private static void solve(int x, int y) {
		int max = 0;
		if(x + 3 < N)
		{
			int sum = arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+3][y];
			max = Math.max(max, sum);
		}
		if(y + 3 < M)
		{
			int sum = arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x][y+3];
			max = Math.max(max, sum);
		}
		if(x + 1 < N && y + 1 < M)
		{
			int sum = arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x+1][y+1];
			max = Math.max(max, sum);
		}
		if(x + 2 < N && y + 1 < M)
		{
			max = Math.max(arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y+1], max);
			max = Math.max(arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x+2][y], max);
			max = Math.max(arr[x][y+1] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y], max);
			max = Math.max(arr[x][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x+2][y+1], max);
			max = Math.max(arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+2][y+1], max);
			max = Math.max(arr[x][y+1] + arr[x+1][y+1] + arr[x+2][y+1] + arr[x+2][y], max);
			max = Math.max(arr[x][y+1] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y+1], max);
			max = Math.max(arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y], max);
		}
		if(x + 1 < N && y + 2 < M)
		{
			max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+1]);
			max = Math.max(max, arr[x+1][y] + arr[x+1][y+1] + arr[x+1][y+2] + arr[x][y+1]);
			max = Math.max(max, arr[x+1][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x][y+2]);
			max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x+1][y+2]);
			max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+2]);
			max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x][y+2]);
			max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+1][y+2]);
			max = Math.max(max, arr[x][y+2] + arr[x+1][y] + arr[x+1][y+1] + arr[x+1][y+2]);
		}
		res = Math.max(res, max);
	}
}