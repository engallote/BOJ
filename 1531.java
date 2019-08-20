import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[101][101];
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int a = x; a <= x2; a++)
				for(int b = y; b <= y2; b++)
					arr[a][b]++;
		}
		
		int cover = 0;
		for(int i = 1; i <= 100; i++)
			for(int j = 1; j <= 100; j++)
				if(arr[i][j] > M) cover++;
		
		System.out.println(cover);
	}
}