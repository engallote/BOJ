import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		Arrays.sort(arr);
		
		long maxNum = arr[0];
		int cnt = 1, max = 0;
		for(int i = 0; i < N-1; i++)
		{
			if(arr[i] == arr[i+1])
				cnt++;
			else
				cnt = 1;
			
			if(max < cnt)
			{
				max = cnt;
				maxNum = arr[i];
			}
		}
		System.out.println(maxNum);
		sc.close();
	}
}