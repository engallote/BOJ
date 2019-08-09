import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		Arrays.fill(arr, 1000000000);
		int[][] path = new int[M][3];
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			path[i][0] = a;
			path[i][1] = b;
			path[i][2] = c;
		}
		int s = sc.nextInt();
		int e = sc.nextInt();
		arr[s] = 0;
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i = 0; i < M; i++)
			{
				if(arr[path[i][0]] + path[i][2] < arr[path[i][1]])
				{
					arr[path[i][1]] = arr[path[i][0]] + path[i][2];
					flag = true;
				}
			}
		}
		
//		for(int i = 1; i <= N; i++)
//			System.out.println(arr[i]);
		System.out.println(arr[e]);
	}
}