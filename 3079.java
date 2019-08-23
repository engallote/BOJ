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
		
		if(N == 1)
			System.out.println(N*M);
		else if(M == 1)
			System.out.println(arr[0]);
		else
		{
			long l = 0, h = 987654321987654l, res = Long.MAX_VALUE;
			
			while(l <= h)
			{
				long mid = (l + h) / 2;
				long sum = 0;
				
				for(int i = 0; i < N; i++)
					sum += mid / arr[i];
				if(sum >= M)
				{
					res = Math.min(res, mid);
					h = mid - 1;
				}
				else l = mid + 1;
			}
			System.out.println(res);
		}
	}
}