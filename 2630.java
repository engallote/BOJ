import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		boolean flag = false;
		int num = N;
		int blue = 0, white = 0;
		while(num > 0)
		{
			int x = 0, y = 0;
			while(x < N)
			{
				flag = true;
				int color = arr[x][y];
				for(int i = x; i < x + num; i++)
				{
					for(int j = y; j < y + num; j++)
						if(color != arr[i][j])
						{
							flag = false;
							break;
						}
					if(!flag) break;
				}
				if(flag)
				{
					for(int i = x; i < x + num; i++)
					{
						for(int j = y; j < y + num; j++)
							arr[i][j] = -1;
					}
					if(color == 1) blue++;
					else if(color == 0) white++;
				}
				y += num;
				if(y >= N)
				{
					x += num;
					y = 0;
				}
//				System.out.println(x + ", " + y);
			}
			int cnt = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(arr[i][j] == -1) cnt++;
//					System.out.print(arr[i][j] + " ");
				}
//				System.out.println();
			}
//			System.out.println("-------------");
			if(cnt == N * N) break;
			num /= 2;
		}
		System.out.println(white);
		System.out.println(blue);
	}
}