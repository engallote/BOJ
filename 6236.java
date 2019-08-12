import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		int max = 0;
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		int l = 0, h = 1000000, mid;
		while(l <= h)
		{
			mid = (l + h) / 2;
			if(mid < max)
			{
				l = mid + 1;
				continue;
			}
			int cur = mid, cnt = 0;
			for(int i = 0; i < N; i++)
			{
				if(cur < arr[i])
				{
					cnt++;
					cur = mid - arr[i];
				}
				else cur -= arr[i];
			}
			
			if(cnt >= M)  l = mid + 1;
			else h = mid - 1;
		}
		System.out.println(l);
	}
}