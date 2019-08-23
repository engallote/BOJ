import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int K = sc.nextInt();
		int[][] arr = new int[K][2];
		for(int i = 0; i < K; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
		}
		
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int cnt = 0, sum = 0;
		while(cnt < K)
		{
			int min = 0;
			
			if(arr[cnt][0] == 1)//북
			{
//				System.out.println(sy + " " + arr[cnt][1] + " " + N);
				if(arr[cnt][0] == sx)//같은 변
					min = Math.abs(sy - arr[cnt][1]);
				else if(sx == 2)//맞은편 변
					min = Math.min(sy + arr[cnt][1], (M - sy) + (M - arr[cnt][1])) + N;			
				else if(sx == 3)
					min = sy + arr[cnt][1];
				else if(sx == 4)
					min = sy + (M - arr[cnt][1]);
			}
			else if(arr[cnt][0] == 2)//남
			{
				if(arr[cnt][0] == sx)//같은 변
					min = Math.abs(sy - arr[cnt][1]);
				else if(sx == 1)//맞은편 변
					min = Math.min(sy + arr[cnt][1], (M - sy) + (M - arr[cnt][1])) + N;			
				else if(sx == 3)
					min = (N - sy) + arr[cnt][1];
				else if(sx == 4)
					min = (N - sy) + (M - arr[cnt][1]);
			}
			else if(arr[cnt][0] == 3)//서
			{
				if(arr[cnt][0] == sx)//같은 변
					min = Math.abs(sy - arr[cnt][1]);
				else if(sx == 1)
					min = sy + arr[cnt][1];
				else if(sx == 2)
					min = sy + (N - arr[cnt][1]);
				else if(sx == 4)
					min =  Math.min(sy + arr[cnt][1] + M, (N - sy) + (N - arr[cnt][1]) + M);
			}
			else//동
			{
				if(arr[cnt][0] == sx)//같은 변
					min = Math.abs(sy - arr[cnt][1]);
				else if(sx == 1)
					min = sy + (M - arr[cnt][1]);
				else if(sx == 2)
					min = (N - sy) + (M - arr[cnt][1]);
				else if(sx == 3)
					min =  Math.min(sy + arr[cnt][1] + M, (N - sy) + (N - arr[cnt][1]) + M);
			}
//			System.out.println(min);
			sum += min;
			cnt++;
		}
		System.out.println(sum);
	}
}