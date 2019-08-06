import java.util.*;

public class Main {
	static int N, M, H, res = -1;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//세로선
		M = sc.nextInt();//가로선
		H = sc.nextInt();//가로선을 놓을 수 있는 위치 개수
		
		if(M == 0)
		{
			System.out.println(0);
			return;
		}
		arr = new int[H+1][N+1];
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = b + 1;
			arr[a][b+1] = b;
		}
		for(int i = 0; i <= 3; i++)
		{
			solve(0, i);
			if(res != -1) break;
		}
		System.out.println(res);
	}
	private static void solve(int cnt, int until) {
		if(res != -1) return;
		if(cnt == until)
		{
			for(int i = 1; i < N; i++)
			{
				int start = i, h = 1;
				while(h <= H)
				{
					if(arr[h][start] > 0)
					{
						if(start + 1 <= N && arr[h][start+1] == start)
							start = start + 1;
						else if(start - 1 >= 1 && arr[h][start-1] == start)
							start = start - 1;
					}
					h++;
				}
				if(start != i) return;
			}
			res = until;
			return;
		}
		
		for(int i = 1; i <= H; i++)
		{
			for(int j = 1; j < N; j++)
				if(arr[i][j] == 0 && arr[i][j+1] == 0)
				{
					arr[i][j] = j + 1;
					arr[i][j+1] = j;
					solve(cnt + 1, until);
					arr[i][j] = arr[i][j+1] = 0;
				}
		}
	}
}