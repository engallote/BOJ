import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] arr = new int[N+1], sum = new int[N+1];
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			if(i > 1)
				sum[i] = Math.abs(arr[i] - arr[i-1]) + sum[i-1];
		}
		
		for(int i = 0; i < Q; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == b)
				System.out.println(0);
			else
				System.out.println(sum[b] - sum[a]);
		}
	}
}