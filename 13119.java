import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		char[][] arr = new char[N][M];
		for(int i = 0; i < N; i++)
			Arrays.fill(arr[i], '.');
		int idx = N - 1, mid = N - X;
		for(int t = 1; t <= M; t++)
		{
			int h = sc.nextInt();//산 높이
			idx = N - 1;
			if(t % 3 == 0)//다리 세우기
			{
				while(idx > mid)
				{
					arr[idx][t-1] = '|';
					idx--;
				}
			}
			idx = N - 1;
			while(h > 0)
			{
				arr[idx][t-1] = '#';
				h--;
				idx--;
			}
		}
		
		for(int i = 0; i < M; i++)
		{
			if(arr[mid][i] == '#') arr[mid][i] = '*';
			else arr[mid][i] = '-';
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
}