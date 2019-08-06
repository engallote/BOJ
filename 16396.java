import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			pq.add(new Pair(x, y));
		}
		
		int start = pq.peek().x, end = pq.poll().y;
		int res = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.x <= end)
				end = Math.max(p.y, end);
			else
			{
				res += end - start;
				start = p.x;
				end = p.y;
			}
		}
		res += end - start;
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else if(o.x == this.x)
		{
			if(o.y < this.y) return -1;
			else return 1;
		}
		else return 1;
	}
}