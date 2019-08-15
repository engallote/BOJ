import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] num = new boolean[100001];
		long[] arr = new long[100001];
		int idx = 0;
		for(int i = 2; i <= 100000; i++)
		{
			if(num[i]) continue;
			arr[idx] = i;
			idx++;
			for(int j = i + i; j <= 100000; j+=i)
				num[j] = true;
		}
		
		int T  = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			long res = 0;
			int sw = 1;
			
			for(long i : arr)
			{
				if(i >= a && i <= b)
				{
					if(sw == 1) res += i * 3;
					else res -= i;
					sw *= -1;
				}
				else if(i > b || i == 0) break;
			}
			System.out.println(res);
		}
	}
}