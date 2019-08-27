import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int cnt = 1;
		long sum = 0;
		for(int i = N-1; i >= 0; i--)
		{
			int tmp = arr[i] - (cnt - 1);
			if(tmp <= 0)
				break;
			
			sum += tmp;
			cnt++;
		}
		System.out.println(sum);
	}
}