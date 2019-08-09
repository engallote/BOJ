import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] visit = new boolean[1000001];
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(N, 0));
		visit[N] = true;
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.num == 1)
			{
				System.out.println(p.cnt);
				return;
			}
			if(p.num % 3 == 0 && !visit[p.num / 3])
			{
				visit[p.num/3] = true;
				q.offer(new Pair(p.num/3, p.cnt+1));
			}
			if(p.num % 2 == 0 && !visit[p.num/2])
			{
				visit[p.num/2] = true;
				q.offer(new Pair(p.num/2, p.cnt+1));
			}
			if(p.num - 1 >= 1 && !visit[p.num-1])
			{
				visit[p.num-1] = true;
				q.offer(new Pair(p.num-1, p.cnt+1));
			}
		}
	}
}
class Pair{
	int num, cnt;
	Pair(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}