import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1)
		{
			System.out.println(4);
			return;
		}
		long[] arr = new long[N+1];
		arr[1] = arr[2] = 1;
		for(int i = 3; i <= N; i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		long res = (arr[N] * 2) + ((arr[N] + arr[N-1]) * 2);
		System.out.println(res);
	}
}