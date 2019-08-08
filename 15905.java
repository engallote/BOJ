import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
		{
			int ac = sc.nextInt();
			int p = sc.nextInt();
			pq.add(new Pair(ac, p));
		}

		int cnt = 0, res = 0, ac = 0;
		while(cnt < 5)
		{
			ac = pq.poll().ac;
			cnt++;
		}
		
		while(!pq.isEmpty())
		{
			if(pq.poll().ac == ac) res++;
			else break;
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int ac, p;
	Pair(int ac, int p)
	{
		this.ac = ac;
		this.p = p;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.ac > this.ac) return 1;
		else if(o.ac == this.ac)
		{
			if(o.p > this.p) return -1;
			else return 1;
		}
		else return -1;
	}
}