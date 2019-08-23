import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int tmpMax = 0;
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i] > tmpMax)
				tmpMax = arr[i];
		}
		
		
		long l = 0, h = Long.MAX_VALUE;
		long res = h;
		while(l <= h)
		{
			int bluelay = 1;
			long mid = (l + h) / 2;
			long sum = 0;

			for(int i = 1; i <= N; i++)
			{
				if(sum + arr[i] <= mid)
					sum += arr[i];
				else
				{
					sum = arr[i];
					bluelay++;
				}
			}

			if(bluelay <= M)
			{
				res = mid;
				h = mid - 1;
			}
			else
				l = mid + 1;
		}
		System.out.println(Math.max(res, tmpMax));
	}
}