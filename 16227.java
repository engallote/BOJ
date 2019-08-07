import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int end = N+1;
		arr = new ArrayList[N+2];
		int[][] chk = new int[N+2][N+2];
		
		for(int i = 0; i <= N + 1; i++)
		{
			Arrays.fill(chk[i], 1000000000);
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int t = sc.nextInt();
			arr[a].add(new Pair(b, t));
			arr[b].add(new Pair(a, t));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0, 0, N));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.v == end)
			{
//				System.out.println(p.v+ " " + p.t + " " + p.cost);
				System.out.println(p.cost+p.t);
				break;
			}
			
			for(Pair next : arr[p.v])
			{
				if(next.t > 100) continue;
				int curTime = p.t;
				if(p.k > 0 && curTime + next.t > 100 && chk[p.v][next.v] >= p.cost + curTime + next.t + 5)
				{
					chk[p.v][next.v] = p.cost + curTime + next.t + 5;
					pq.add(new Pair(next.v, next.t, p.cost + 5 + curTime, p.k - 1));
				}
				if(curTime + next.t <= 100 && chk[p.v][next.v] >= p.cost + curTime + next.t)
				{
					chk[p.v][next.v] = p.cost + curTime + next.t;
					pq.add(new Pair(next.v, next.t + curTime, p.cost, p.k));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v, t, cost, k;
	Pair(int v, int t){
		this.v = v;
		this.t = t;
	}
	Pair(int v, int t, int cost, int k){
		this.v = v;
		this.t = t;
		this.cost = cost;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : 1;
	}
}