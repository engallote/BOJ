import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int res = 0;
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			for(int j = 0; j < N; j++)
				if(arr[j][0] <= num)
				{
					int tmp = arr[j][0];
					arr[j][0] = arr[j][1];
					arr[j][1] = tmp;
				}
		}
		
		for(int i = 0; i < N; i++)
			res += arr[i][0];
		System.out.println(res);
	}
}