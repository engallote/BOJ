import java.util.*;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		pq.add(N);
		pq.add(1);
		solve(N);
		if(pq.size() < K)
			System.out.println(0);
		else
		{
			while(K > 1)
			{
				pq.poll();
				K--;
			}
			System.out.println(pq.poll());
		}
	}

	private static void solve(int n) {
		int a = 2;
		while(a < n)
		{
			if(n % a == 0)
				pq.add(a);		
			a++;
		}
	}
}