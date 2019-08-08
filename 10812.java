import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = i;
		Queue<Integer> left = new LinkedList<>(), right = new LinkedList<>();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int mid = sc.nextInt();
			left.clear();
			right.clear();
			
			for(int j = a; j < mid; j++)
				left.add(arr[j]);
			for(int j = mid; j <= b; j++)
				right.add(arr[j]);
			
			for(int j = a; j <= b; j++)
			{
				if(!right.isEmpty()) arr[j] = right.poll();
				else arr[j] = left.poll();
			}
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(arr[i] + " ");
	}
}