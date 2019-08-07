import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int l = 0, h = 1000000, mid, res = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			int up = 0;
			for(int i = 0; i < N; i++)
				if(arr[i] >= mid) up++;
			
			if(up >= mid)
			{
				res = mid;
				l = mid + 1;
			}
			else h = mid - 1;
		}
		System.out.println(res);
	}
}