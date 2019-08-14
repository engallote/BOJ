import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++)
			pq.add(new Pair(i, sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		System.out.println(pq.peek().idx);
	}
}
class Pair implements Comparable<Pair>{
	int idx, s, c, l;
	Pair(int idx, int s, int c, int l){
		this.idx = idx;
		this.s = s;
		this.c = c;
		this.l = l;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return 1;
		else if(o.s == this.s)
		{
			if(o.c > this.c) return -1;
			else if(o.c == this.c)
			{
				if(o.l > this.l) return -1;
				else if(o.l == this.l) return 0;
				else return 1;
			}
			else return 1;
		}
		else return -1;
	}
}