import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		boolean[] chk = new boolean[10000001];
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			chk[arr[i]] = true;
		}
		
		long max = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				long x = arr[j] - arr[i];
				long cnt = 1, sum = arr[i];
				
				for(int k = arr[j]; k <= arr[N-1]; k+=x)
				{
					if(chk[k])
					{
						cnt++;
						sum += k;
					}
					else break;
				}
				if(cnt >= 3 && max < sum)
					max = sum;
			}
		}
		
		System.out.println(max);
	}
}