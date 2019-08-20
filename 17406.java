import java.util.*;

public class Main {
	static int N, M, K, res = Integer.MAX_VALUE;
	static int[][] arr, order, tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		tmp = new int[N][M];
		order = new int[K][3];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 0; i < K; i++)
		{
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int s = sc.nextInt();
			order[i][0] = r;
			order[i][1] = c;
			order[i][2] = s;
		}
		ArrayList<Integer> path = new ArrayList<>();
		solve(0, path);
		
		System.out.println(res);
	}
	private static void solve(int idx, ArrayList<Integer> path) {
		if(idx == K)
		{
			copy();
			
			for(int i : path)
				rotate(order[i][0], order[i][1], order[i][2]);
			int sum = 0;
			for(int i = 0; i < N; i++)
			{
				sum = 0;
				for(int j = 0; j < M; j++) sum += tmp[i][j];
				res = Math.min(res, sum);
			}
			return;
		}
		
		for(int i = 0; i < K; i++)
			if(!path.contains(i))
			{
				path.add(i);
				solve(idx + 1, path);
				path.remove(path.size()-1);
			}
	}
	private static void copy() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				tmp[i][j] = arr[i][j];
	}
	private static void rotate(int r, int c, int s) {
		int sx = r - s, sy = c - s, ex = r + s, ey = c + s;
		
		while(sx < ex)
		{
			int tmp2 = tmp[sx][sy];
			for(int i = sx; i < ex; i++)
				tmp[i][sy] = tmp[i+1][sy];
			for(int i = sy; i < ey; i++)
				tmp[ex][i] = tmp[ex][i + 1];
			for(int i = ex; i > sx; i--)
				tmp[i][ey] = tmp[i-1][ey];
			for(int i = ey; i > sy + 1; i--)
				tmp[sx][i] = tmp[sx][i-1];
			tmp[sx][sy + 1] = tmp2;
			sx++;
			sy++;
			ex--;
			ey--;
		}
	}
}