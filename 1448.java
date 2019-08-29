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
		
		int maxLen = 0;
		
		for(int i = 0; i < N-2; i++)
		{
			if(arr[i+2] < arr[i] + arr[i+1])
			{
				int sum = arr[i] + arr[i+1] + arr[i+2];
				if(maxLen < sum)
					maxLen = sum;
			}
		}
		
		if(maxLen == 0)
			System.out.println(-1);
		else
			System.out.println(maxLen);
	}
}
// a + b > c을 만족해야 삼각형이 결정된다.