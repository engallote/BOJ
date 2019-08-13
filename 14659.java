import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		int[] sum = new int[N+1];
		int max = 0;
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i - 1] > arr[i])
			{
				arr[i] = arr[i-1];
				sum[i] = sum[i-1] + 1;
				max = Math.max(sum[i], max);
			}
		}
		
		System.out.println(max);
	}
}