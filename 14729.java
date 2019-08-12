import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++)
		{
			pq.add(sc.nextDouble());
			if(pq.size() > 7) pq.poll();
		}
		PriorityQueue<Double> ans = new PriorityQueue<>();
		ans.addAll(pq);
		while(!ans.isEmpty())
			System.out.println(String.format("%.3f", ans.poll()));
	}
}