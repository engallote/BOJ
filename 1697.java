import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] time = new int[100001];
		Arrays.fill(time, -1);
		time[N] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty())
		{
			int here = q.poll();
			if(here == K)
			{
				System.out.println(time[K]);
				break;
			}
			
			if(here + 1 <= 100000 && time[here + 1] < 0)
			{
				time[here + 1] = time[here] + 1;
				q.offer(here + 1);
			}
			if(here - 1 >= 0 && time[here - 1] < 0)
			{
				time[here - 1] = time[here] + 1;
				q.offer(here - 1);
			}
			if(here * 2 <= 100000 && time[here * 2] < 0)
			{
				time[here * 2] = time[here] + 1;
				q.offer(here * 2);
			}
		}
	}
}