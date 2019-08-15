import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		ArrayList<Pair>[] path = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) path[i] = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			path[a].add(new Pair(b, c));
			path[b].add(new Pair(a, c));
		}
		
		if(N == 1)
		{
			System.out.println(0);
			return;
		}
		int[] chk1 = new int[N+1], chk2 = new int[N+1];
		Arrays.fill(chk1, Integer.MAX_VALUE);
		Arrays.fill(chk2, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		pq.offer(new Pair(A, 0));
		chk1[A] = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			for(Pair next : path[p.v])
				if(chk1[next.v] > p.cost + next.cost)
				{
					chk1[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, p.cost + next.cost));
				}
		}
		
		pq.clear();
		pq.offer(new Pair(B, 0));
		chk2[B] = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			for(Pair next : path[p.v])
				if(chk2[next.v] > p.cost + next.cost)
				{
					chk2[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, p.cost + next.cost));
				}
		}
		long res = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
		{
			res = Math.min(res, (long)((long)chk1[i] + (long)chk2[i]));
			for(Pair p : path[i])
				res = Math.min(res, (long)((long)chk1[i] + (long)chk2[p.v]));
		}
			
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : 1;
	}
}