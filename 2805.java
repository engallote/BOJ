import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		Arrays.sort(arr);
		
		long l = 1, h = arr[N-1], mid = 0, res = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++)
			{
				if(arr[i] <= mid) continue;
				sum += (arr[i] - mid);
			}
			if(sum >= M)
			{
				res = Math.max(res, mid);
				l = mid + 1;
			}
			else
				h = mid - 1;
		}
		System.out.println(res);
	}
}