import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int res = 0, idx = N - 1;
		while(idx >= 0)
		{
			if(idx - 2 >= 0)
			{
				res += arr[idx] + arr[idx-1] + arr[idx-2];
				res -= arr[idx-2];
			}
			else
			{
				for(int j = idx; j >= 0; j--)
					res += arr[j];
			}
			idx -= 3;
		}
		System.out.println(res);
	}
}