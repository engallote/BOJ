import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE, num = 0;
		for(int i = 0; i < N; i++)
		{
			long sum = 0;
			for(int j = 0; j < N; j++)
				sum += Math.abs(arr[i] - arr[j]);
			if(min > sum)
			{
				min = sum;
				num = arr[i];
			}
		}
		System.out.println(num);
	}
}