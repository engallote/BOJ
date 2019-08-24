import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		while(!q.isEmpty())
		{
			int now = q.poll();
			if(now == 0)
			{
				System.out.println(num[now]);
				return;
			}
			
			if(now - 5 >= 0 && num[now - 5] == 0)
			{
				num[now - 5] = num[now] + 1;
				q.offer(now - 5);
			}
			if(now - 3 >= 0 && num[now - 3] == 0)
			{
				num[now - 3] = num[now] + 1;
				q.offer(now - 3);
			}
		}
		System.out.println(-1);
	}
}