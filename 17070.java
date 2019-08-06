import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		int res = solve(0, 1, 1);
		System.out.println(res);
	}
	private static int solve(int x, int y, int pipe) {
		if(x == N - 1 && y == N - 1) return 1;
		int ret = 0;
		//가로
		if(pipe == 1)
		{
			if(y + 1 < N && arr[x][y+1] != 1) ret += solve(x, y + 1, pipe);
			if(x + 1 < N && y + 1 < N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1)
				ret += solve(x + 1, y + 1, 3);
		}
		else if(pipe == 2)
		{
			if(x + 1 < N && arr[x+1][y] != 1) ret += solve(x + 1, y, pipe);
			if(x + 1 < N && y + 1 < N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1)
				ret += solve(x + 1, y + 1, 3);
		}
		else if(pipe == 3)
		{
			if(y + 1 < N && arr[x][y+1] != 1) ret += solve(x, y + 1, 1);
			if(x + 1 < N && arr[x+1][y] != 1) ret += solve(x + 1, y, 2);
			if(x + 1 < N && y + 1 < N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1)
				ret += solve(x + 1, y + 1, pipe);
		}
		return ret;
	}
}