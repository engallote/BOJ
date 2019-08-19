import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int J = sc.nextInt();
			int N = sc.nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i = 0; i < N; i++)
			{
				int r = sc.nextInt();
				int c = sc.nextInt();
				pq.add(r*c);
			}
			
			int sum = 0, cnt = 0;
			while(!pq.isEmpty())
			{
				if(sum + pq.peek() < J)
				{
					sum += pq.poll();
					cnt++;
				}
				else if(sum + pq.peek() >= J)
				{
					sum += pq.poll();
					cnt++;
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}