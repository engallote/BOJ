import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int max = 0, who = 0, sum = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i = 1; i <= N; i++)
			{
				int num = sc.nextInt();
				pq.add(num);
				sum += num;
				if(num > max)
				{
					max = num;
					who = i;
				}
			}
			int a = pq.poll();
			if(a == pq.peek())
				System.out.println("no winner");
			else
			{
				if(sum / 2 < a)
					System.out.println("majority winner " + who);
				else
					System.out.println("minority winner " + who);
			}
		}
	}
}