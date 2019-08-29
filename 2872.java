import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int max = N;
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = N; i >= 1; i--)
		{
			if(arr[i]== max)
				max--;
		}
		
		System.out.println(max);
	}
}