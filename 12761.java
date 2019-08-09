import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] visit = new boolean[100001];
		visit[N] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(N, 0));
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.x == M)
			{
				System.out.println(p.cnt);
				return;
			}
			
			if(p.x + 1 <= 100000 && !visit[p.x+1])
			{
				visit[p.x+1] = true;
				q.offer(new Pair(p.x+1, p.cnt+1));
			}
			if(p.x - 1 >= 0 && !visit[p.x-1])
			{
				visit[p.x-1] = true;
				q.offer(new Pair(p.x-1, p.cnt+1));
			}
			if(p.x + A <= 100000 && !visit[p.x+A])
			{
				visit[p.x+A] = true;
				q.offer(new Pair(p.x+A, p.cnt+1));
			}
			if(p.x - A >= 0 && !visit[p.x-A])
			{
				visit[p.x-A] = true;
				q.offer(new Pair(p.x-A, p.cnt+1));
			}
			if(p.x * A <= 100000 && !visit[p.x*A])
			{
				visit[p.x*A] = true;
				q.offer(new Pair(p.x*A, p.cnt+1));
			}
			if(p.x + B <= 100000 && !visit[p.x+B])
			{
				visit[p.x+B] = true;
				q.offer(new Pair(p.x+B, p.cnt+1));
			}
			if(p.x - B >= 0 && !visit[p.x-B])
			{
				visit[p.x-B] = true;
				q.offer(new Pair(p.x-B, p.cnt+1));
			}
			if(p.x * B <= 100000 && !visit[p.x*B])
			{
				visit[p.x*B] = true;
				q.offer(new Pair(p.x*B, p.cnt+1));
			}
		}
	}
}
class Pair{
	int x, cnt;
	Pair(int x, int cnt){
		this.x = x;
		this.cnt = cnt;
	}
}