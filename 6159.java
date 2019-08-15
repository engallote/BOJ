import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int res = 0;
		for(int i = 0; i < N - 1; i++)
		{
			if(arr[i] + arr[N-1] <= M) res += N - i - 1;
			else
			{
				for(int j = i+1; j < N; j++)
				{
					if(arr[i] + arr[j] > M) break;
					res++;
				}
			}
		}
		
		System.out.println(res);
	}
}