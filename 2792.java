import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[M];
		
		for(int i = 0; i < M; i++)
			arr[i] = sc.nextInt();
		
		long l = 0, h = Long.MAX_VALUE, res = h;
		
		while(l <= h)
		{
			long mid = (l + h) / 2;
			long max = 0;
			long sum = 0;
			
			for(int i = 0; i < M; i++)
			{
				sum += arr[i] / mid;
				if(arr[i] % mid > 0)
					sum++;
				max = Math.max(max, Math.max(mid, arr[i] % mid));
			}
			
			if(sum <= N)
			{
				h = mid - 1;
				res = Math.min(res, max);
			}
			else
				l = mid + 1;
		}
		System.out.println(res);
	}
}