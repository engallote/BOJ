import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		long[] arr = new long[N+1];
		for(int t = 0; t < Q; t++)
		{
			int order = sc.nextInt();
			int p = sc.nextInt();
			int x = sc.nextInt();
			
			if(order == 1)
				arr[p] += x;
			else
			{
				long sum = 0;
				for(int i = p; i <= x; i++)
					sum += arr[i];
				System.out.println(sum);
			}
		}
	}
}