import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int res = 0, next = 1;
		for(int i = 0; i < N; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int form = sc.nextInt();
			
			res = Math.abs(res - form);
			if(i == 0)
			{
				arr[i] = a;
				arr[i+1] = b;
			}
			else
			{
				next = arr[i] / a;
				arr[i + 1] = b * next;
//				System.out.println(next);
			}
		}
		
//		for(int i = 0; i <= N; i++)
//			System.out.print(arr[i] + " ");
//		System.out.println();
		
		System.out.println(res + " " + arr[N]);
	}
}