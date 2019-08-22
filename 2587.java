import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < 5; i++)
			pq.add(sc.nextInt());
		
		int sum = 0, mid = 0, cnt = 0;
		while(!pq.isEmpty())
		{
			if(cnt == 2)
				mid = pq.peek();
			sum += pq.poll();
			cnt++;
		}
		
		System.out.println(sum/5);
		System.out.println(mid);
	}
}