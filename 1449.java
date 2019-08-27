import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int cnt = 0, sum = 0;
		for(int i = N-1; i > 0; i--)
		{
			int sub = arr[i] - arr[i-1];
			if(sum + sub < L)
				sum += sub;
			else
			{
				sum = 0;
				cnt++;
			}
		}
		System.out.println(cnt+1);
	}
}