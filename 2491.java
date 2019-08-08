import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int max = 0;
		int[] up = new int[N+1], down = new int[N+1];
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			up[i] = up[i-1];
			down[i] = down[i-1];
			if(arr[i-1] < arr[i]) 
			{
				up[i] += 1;
				down[i] = 1;
			}
			else if(arr[i-1] > arr[i])
			{
				up[i] = 1;
				down[i] += 1;
			}
			else
			{
				up[i] += 1;
				down[i] += 1;
			}
			max = Math.max(max, Math.max(up[i], down[i]));
		}
		System.out.println(max);
//		for(int i = 1; i <= N; i++)
//			System.out.print(up[i] + " ");
//		System.out.println();
//		for(int i = 1; i <= N; i++)
//			System.out.print(down[i] + " ");
	}
}