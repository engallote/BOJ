import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[M];
		
		for(int i = 0; i < M; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int max = arr[M-1], num = arr[M-1];
		int tmp = 0;
		for(int i = 0; i < M - 1; i++)
		{
			tmp = arr[i] * (M - i > N ? N : M - i);
			if(tmp > max)
			{
				max = tmp;
				num = arr[i];
			}
		}
		System.out.println(num + " " + max);
	}
}