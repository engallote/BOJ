import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		int res = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			arr[i] += arr[i-1];
			if(i >= M)
			{
				res = Math.max(res, arr[i] - arr[i-M]);
			}
		}
		System.out.println(res);
	}
}