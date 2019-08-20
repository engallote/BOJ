import java.util.*;

public class Main {
	static int N, M;
	static long[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		arr = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextLong();
		
		for(int i = 0; i < R; i++) rotate();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	private static void rotate() {
		int sx = 0, sy = 0, ex = N-1, ey = M-1;
		
		while(sx < ex && sy < ey)
		{
			long tmp = arr[sx][sy];
			
			for(int i = sy; i < ey; i++)
				arr[sx][i] = arr[sx][i+1];
			for(int i = sx; i < ex; i++)
				arr[i][ey] = arr[i+1][ey];
			for(int i = ey; i > sy; i--)
				arr[ex][i] = arr[ex][i-1];
			for(int i = ex; i > sx; i--)
				arr[i][sy] = arr[i-1][sy];
			arr[sx+1][sy] = tmp;
			sx++;
			sy++;
			ex--;
			ey--;
		}
	}
}