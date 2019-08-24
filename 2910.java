import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		HashMap<Integer, Pair> hs = new HashMap<>();
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(hs.isEmpty())
				hs.put(num, new Pair(1, i));
			else if(!hs.containsKey(num))
				hs.put(num, new Pair(1, i));
			else
			{
				int cnt = hs.get(num).cnt;
				int or = hs.get(num).order;
				hs.remove(num);
				hs.put(num, new Pair(cnt + 1, or));
			}
		}
		
		Set<Integer> key = hs.keySet();
		Iterator<Integer> it = key.iterator();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		while(it.hasNext())
		{
			int num = it.next();
			int cnt = hs.get(num).cnt;
			int order = hs.get(num).order;
			pq.add(new Pair(num, cnt, order));
		}
		
		while(!pq.isEmpty())
		{
			int cnt = pq.peek().cnt;
			int num = pq.poll().num;
			while(cnt > 0)
			{
				System.out.print(num + " ");
				cnt--;
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int num, cnt, order;
	Pair(int num, int cnt, int order)
	{
		this.num = num;
		this.cnt = cnt;
		this.order = order;
	}
	Pair(int cnt, int order)
	{
		this.cnt = cnt;
		this.order = order;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return 1;
		else if(o.cnt < this.cnt) return -1;
		else
		{
			if(o.order > this.order) return -1;
			else return 1;
		}
	}
}