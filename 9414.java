import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int limit = 5000000;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			while(true)
			{
				int num = sc.nextInt();
				if(num == 0) break;
				pq.add(num);
			}
			
			long sum = 0, cnt = 1;
			while(!pq.isEmpty())
			{
				long num = (long)Math.pow(pq.poll(), cnt) * 2;
				sum += num;
				cnt++;
			}
			if(sum > limit) System.out.println("Too expensive");
			else System.out.println(sum);
		}
	}
}