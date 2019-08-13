import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int K = sc.nextInt();
		int num = N / K;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i+=num)
		{
			pq.clear();
			for(int j = i; j < i + num; j++)
				pq.add(arr[j]);
			while(!pq.isEmpty())
				System.out.print(pq.poll() + " ");
		}
	}
}