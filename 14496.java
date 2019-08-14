import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		boolean[] chk = new boolean[N+1];
		for(int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			arr[y].add(x);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(a, 0));
		int res = -1;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.v == b)
			{
				res = p.cnt;
				break;
			}
			
			for(int next : arr[p.v])
				if(!chk[next])
				{
					chk[next] = true;
					pq.add(new Pair(next, p.cnt + 1));
				}
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int v, cnt;
	Pair(int v, int cnt){
		this.v = v;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}