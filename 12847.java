import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] += arr[i-1] + sc.nextInt();
		
		long res = 0;
		for(int i = M; i <= N; i++)
			res = Math.max(res, arr[i] - arr[i-M]);
		System.out.println(res);
	}
}