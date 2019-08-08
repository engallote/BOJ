import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 0)
		{
			System.out.println(0);
			return;
		}
		else if(N == 1)
		{
			System.out.println(1);
			return;
		}
		long[] arr = new long[N+1];
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i = 3; i <= N; i++)
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
		System.out.println(arr[N]);
	}
}