import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Long> q = new PriorityQueue<>();
		Vector<Long> v = new Vector<>();
		for(int i = 0; i < N; i++)
			q.add(sc.nextLong());
		
		if(N == 1)
		{
			System.out.println(0);
			return;
		}
		
		long sum = 0;
		while(!q.isEmpty() && q.size() > 1)
		{
			long tmp = q.poll() + q.poll();
			sum += tmp;
			q.add(tmp);
		}
		
		System.out.println(sum);
	}
}