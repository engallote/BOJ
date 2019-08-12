import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			char c = sc.next().charAt(0);
			pq.add(new Pair(a, b, c));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) sb.append(pq.poll().c);
		
		System.out.println(sb.toString());
	}
}
class Pair implements Comparable<Pair>{
	int a, b;
	char c;
	Pair(int a, int b, char c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.b > this.b) return -1;
		else if(o.b == this.b)
		{
			return o.a > this.a ? -1 : 1;
		}
		return 1;
	}
}