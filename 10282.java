import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int INF = 100000000;
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();
			int[] arr = new int[N+1];
			Arrays.fill(arr, INF);
			int[][] path = new int[d][3];
			
			for(int i = 0; i < d; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int w = sc.nextInt();
				path[i][0] = b;
				path[i][1] = a;
				path[i][2] = w;
			}
			
			arr[c] = 0;
			boolean flag = true;
			
			while(flag)
			{
				flag = false;
				for(int i = 0; i < d; i++)
				{
					if(arr[path[i][0]] + path[i][2] < arr[path[i][1]])
					{
						arr[path[i][1]] = arr[path[i][0]] + path[i][2];
						flag = true;
					}
				}
			}
			
			int max = 0, cnt = 0;
			for(int i = 1; i <= N; i++)
			{
//				System.out.println(arr[i]);
				if(arr[i] != INF)
				{
					cnt++;
					if(max < arr[i])
						max = arr[i];
				}
			}
			System.out.println(cnt + " " + max);
		}
	}
}