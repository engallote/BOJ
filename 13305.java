import java.util.*;

public class Main {
	static int N;
	static long[] dist, gas;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dist = new long[N-1];
		long[] arr = new long[N];
		gas = new long[N];
		
		for(int i = 0; i < N - 1; i++) dist[i] = sc.nextLong();
		for(int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextLong();
			if(i == 0) gas[i] = arr[i];
			else gas[i] = Math.min(gas[i-1], arr[i]);
		}
		
		long res = 0;
		
		for(int i = 0; i < N - 1; i++)
			res += gas[i] * dist[i];
		
		System.out.println(res);
	}
}