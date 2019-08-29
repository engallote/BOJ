import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] res = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int sum =0;
		for(int i = 0; i < N; i++)
		{
			if(i % 2 == 1)
				sum -= arr[i];
			else
				sum += arr[i];
		}
		System.out.println(sum/2);
		
		res[0] = sum / 2;
		for(int i = 1; i < N; i++)
		{
			res[i] = Math.abs(arr[i-1] - res[i-1]);
			System.out.println(res[i]);
		}	
	}
}