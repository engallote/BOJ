import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int n = sc.nextInt();
			int a = sc.nextInt();
			
			if(n == 1)
			{
				int b = sc.nextInt();
				arr[a-1] += b;
			}
			else
			{
				int sum = 0;
				for(int j = 0; j < N; j++)
				{
					sum += arr[j];
					if(a <= sum)
					{
						System.out.println(j+1);
						break;
					}
				}
			}
		}
	}
}