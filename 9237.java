import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int max = 0;
		for(int i = 2, j = N-1; j >= 0; i++, j--)
		{
			if(i + arr[j] > max)
				max = i + arr[j];
		}
		System.out.println(max);
	}
}
