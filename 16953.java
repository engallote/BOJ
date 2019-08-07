import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		HashMap<Long, Integer> hs = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(A, 0));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.x == B)
			{
				System.out.println(p.cnt + 1);
				return;
			}
			
			if(p.x*2 <= B && !hs.containsKey(p.x*2))
			{
				hs.put(p.x * 2, p.cnt + 1);
				pq.add(new Pair(p.x * 2, p.cnt + 1));
			}
			if(p.x * 10 + 1 <= B && !hs.containsKey(p.x * 10 + 1))
			{
				hs.put(p.x * 10 + 1, p.cnt + 1);
				pq.add(new Pair(p.x * 10 + 1, p.cnt + 1));
			}
		}
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	long x;
	int cnt;
	Pair(long x, int cnt)
	{
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}