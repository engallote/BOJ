import java.util.*;

public class Main {
	static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		C = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		long l = 1, h = arr[N-1], res = 0;
		
		while(l <= h)
		{
			long mid = (l + h) / 2;
			int cnt = 1, idx = 0;
			
			for(int i = 0; i < N; i++)
				if(arr[i] - arr[idx] >= mid)
				{
					idx = i;
					cnt++;
				}
			if(cnt >= C)
			{
				l = mid + 1;
				res = Math.max(res, mid);
			}
			else
				h = mid - 1;
		}
		System.out.println(res);
	}
}