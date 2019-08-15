import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long K = sc.nextLong();
		
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		if(N == 1)
		{
			System.out.println(arr[0]+K);
			return;
		}
		
		Arrays.sort(arr);
		
		long l = 0, r = Integer.MAX_VALUE, mid, res = 0;
		while(l <= r)
		{
			mid = (l + r) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++)
				if(arr[i] < mid) sum += mid - arr[i];
			
			if(sum <= K) 
			{
				res = Math.max(res, mid);
				l = mid + 1;
			}
			else r = mid - 1;
		}
		System.out.println(res);
	}
}