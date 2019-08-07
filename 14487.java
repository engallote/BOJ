import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1], sum = new int[N+1];
		
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		
		int res = Integer.MAX_VALUE, idx = 0, jump = N - 2;
		for(int i = 1; i <= N; i++)
		{
			idx = i + jump;
			int num = 0;
			if(idx > N)
			{
				num = sum[N] - sum[i - 1];
				num += sum[i - 2];
			}
			else
				num = sum[idx] - sum[i - 1];
//			if(res > num) System.out.println(">> " + i);
			res = Math.min(res, num);
		}
		System.out.println(res);
	}
}