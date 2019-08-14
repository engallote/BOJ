import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Pair>[] arr = new ArrayList[N+1];
		boolean[][] chk = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		int K = sc.nextInt();
		
		for(int i = 0; i < K; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int t = sc.nextInt();
			int m = sc.nextInt();
			arr[a].add(new Pair(b, t, m));
			arr[b].add(new Pair(a, t, m));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1, 0, 0));
		int res = -1;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.v == N)
			{
				res = p.m;
				break;
			}
			for(Pair next : arr[p.v])
				if(!chk[p.v][next.v] && p.t + next.t <= T && p.m + next.m <= M)
				{
					chk[p.v][next.v] = true;
					pq.add(new Pair(next.v, p.t + next.t, p.m + next.m));
				}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int v, t, m;
	Pair(int v, int t, int m){
		this.v = v;
		this.t = t;
		this.m = m;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.m > this.m) return -1;
		else if(o.m == this.m)
		{
			if(o.t > this.t) return -1;
			else if(o.t == this.t) return 0;
			else return 1;
		}
		else return 1;
	}
}