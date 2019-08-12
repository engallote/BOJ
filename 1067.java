import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long max = 0;
		int[] arr1 = new int[N], arr2 = new int[N];
//		Random rd = new Random();
		for(int i = 0; i < N; i++)
		{
			arr1[i] = sc.nextInt();
//			arr1[i] = rd.nextInt(101);
		}
		for(int i = 0; i < N; i++)
		{
			arr2[i] = sc.nextInt();
//			arr2[i] = rd.nextInt(101);
		}
		
		for(int i = 0; i < N; i++)
		{
			int idx = 0;
			long sum = 0;
			for(int j = i; j < N; j++)
			{
				sum += arr1[j] * arr2[idx];
				idx++;
			}
			for(int j = 0; j < i; j++)
			{
				sum += arr1[j] * arr2[idx];
				idx++;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}