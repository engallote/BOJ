import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int U = sc.nextInt();
		int D = sc.nextInt();
		int V = sc.nextInt();
		
		long l = 1, h = V, mid = 0, res = 0;
		while(l <= h)
		{
			mid = (l + h) / 2;
			long sum = 0;
				sum += (U-D) * (mid - 1);
			sum += U;
			if(sum >= V)
			{
				h = mid - 1;
				res = mid;
			}
			else
				l = mid + 1;
		}
		System.out.println(res);
	}
}