import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int C = sc.nextInt();
		long[] arr = new long[S];
		long all = 0;
		
		for(int i = 0; i < S; i++)
		{
			arr[i] = sc.nextLong();
			all += arr[i];
		}
		
		Arrays.sort(arr);
		
		long l = 1, h = Long.MAX_VALUE-1, mid, ans = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			int cnt = 0;
			
			for(int i = 0; i < S; i++)
				cnt += (arr[i] / mid);
			
			if(cnt >= C)
			{
				ans = Math.max(ans, mid);
				l = mid + 1;
			}
			else
				h = mid - 1;
		}
		System.out.println((all - ans * C));
	}
}