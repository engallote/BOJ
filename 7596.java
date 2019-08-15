import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			int N = sc.nextInt();
			sc.nextLine();
			if(N == 0) break;
			PriorityQueue<String> pq = new PriorityQueue<>();
			for(int i = 0; i < N; i++)
				pq.offer(sc.nextLine());
			System.out.println(tc);
			while(!pq.isEmpty()) System.out.println(pq.poll());
			tc++;
		}
	}
}