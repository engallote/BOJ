import java.util.*;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 int M = sc.nextInt();
		 ArrayList<Integer>[] arr = new ArrayList[N+1];
		 for(int i = 1; i <= N; i++)
			 arr[i] = new ArrayList<>();
		 
		 for(int i = 0; i < M; i++)
		 {
			 int a = sc.nextInt();
			 int b = sc.nextInt();
			 arr[a].add(b);
			 arr[b].add(a);
		 }
		 
		 for(int i = 1; i <= N; i++)
			 System.out.println(arr[i].size());
	}
}