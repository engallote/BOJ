import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>(), tmp = new PriorityQueue<>();
		pq.add(new Pair(1, 3));
		
		for(int i = 2; i <= N; i++)
		{
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				if(p.cnt - 1 > 0) tmp.add(new Pair(p.year, p.cnt - 1));
				if(i % 2 == 0) tmp.add(new Pair(i, 4));
				else tmp.add(new Pair(i, 3));
			}
			pq.addAll(tmp);
			tmp.clear();
		}
		
		System.out.println(pq.size());
	}
}
class Pair implements Comparable<Pair>{
	int year, cnt;
	Pair(int year, int cnt)
	{
		this.year = year;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}