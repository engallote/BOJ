import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int num = sc.nextInt();
			
			for(int j = a; j <= b; j++)
				arr[j] = num;
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(arr[i] + " ");
	}
}