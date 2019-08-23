import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		long[] arr = new long[K];
		for(int i = 0; i < K; i++)
			arr[i] = sc.nextLong();
		
		long l = 0, h = Long.MAX_VALUE, res = 0, mid = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			int sum = 0;
			
			for(int i = 0; i < K; i++)
				sum += (arr[i] / mid);
//			System.out.println(mid + " " + sum);
			if(sum >= N)
			{
				res = Math.max(res, mid);
				l = mid + 1;
			}
			else if(sum < N)
				h = mid - 1;
		}
		System.out.println(res);
	}
}