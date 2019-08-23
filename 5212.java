import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		int M = sc.nextInt();
		
		if(sum <= M)
		{
			Arrays.sort(arr);
			System.out.println(arr[N-1]);
			return;
		}
		
		int l = 0, h = M, mid = 0, res = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			sum = 0;
			
			for(int i = 0; i < N; i++)
			{
				if(arr[i] > mid)
					sum += mid;
				else
					sum += arr[i];
			}
			
			if(sum > M)
				h = mid - 1;
			else
			{
				l = mid + 1;
				res = Math.max(res, mid);
			}
		}
		System.out.println(res);
	}
}