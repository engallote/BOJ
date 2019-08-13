import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			int l = 1, h = Integer.MAX_VALUE - 1, mid, dist = h;
			
			while(l <= h)
			{
				mid = (l + h) / 2;
//				System.out.println(l + " " + h);
				int sum = (mid-arr[0]) * 2 + (arr[N-1] - mid) * 2;
//				System.out.println(dist + " . " + sum);
				if(dist >= sum)
				{
					dist = sum;
					h = mid - 1;
				}
				else l = mid + 1; 
			}
			System.out.println(dist);
		}
	}
}