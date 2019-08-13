import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringBuilder sb;
		for(int i = 0; i < N; i++)
		{
			sb = new StringBuilder();
			sb.append(sc.next());
			sb.reverse();
			pq.add(Long.parseLong(sb.toString()));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
}