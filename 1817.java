import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int cnt = 0, sum = 0;
		
		for(int i = 0; i < N; i++)
		{
			if(sum + arr[i] < M)
				sum += arr[i];
			else if(sum + arr[i] == M)
			{
				sum = 0;
				cnt++;
			}
			else
			{
				sum = arr[i];
				cnt++;
			}
		}
		if(sum > 0)
			cnt++;
		System.out.println(cnt);
	}
}