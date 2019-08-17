import java.util.*;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 int[] arr = new int[N+1];
		 
		 for(int i = 1; i <= N; i++)
		 {
			 arr[i] = sc.nextInt();
			 arr[i] += arr[i-1];
		 }
		 
		 int M = sc.nextInt();
		 for(int i = 0; i < M; i++)
		 {
			 int a = sc.nextInt();
			 int b = sc.nextInt();
			 
			 if(a == b)
				 System.out.println(arr[b]-arr[b-1]);
			 else
				 System.out.println(arr[b]-arr[a-1]);
		 }
	}
}