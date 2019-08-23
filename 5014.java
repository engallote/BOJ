import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		boolean[] visit = new boolean[F+1];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(S, 0));
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			
			if(p.n == G)
			{
				System.out.println(p.cnt);
				return;
			}
			
			if(p.n + U <= F && !visit[p.n + U])
			{
				visit[p.n + U] = true;
				q.offer(new Pair(p.n + U, p.cnt + 1));
			}
			if(p.n - D >= 1 && !visit[p.n - D])
			{
				visit[p.n - D] = true;
				q.offer(new Pair(p.n - D, p.cnt + 1));
			}
		}
		
		System.out.println("use the stairs");
	}
}
class Pair{
	int n, cnt;
	Pair(int n, int cnt)
	{
		this.n = n;
		this.cnt = cnt;
	}
}