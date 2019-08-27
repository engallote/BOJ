import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			pq.add(new Pair(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().name);
	}	
}
class Pair implements Comparable<Pair>{
	String name;
	int k, e, m;
	Pair(String name, int k, int e, int m)
	{
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.k > this.k) return 1;
		else if(o.k == this.k)
		{
			if(o.e > this.e) return -1;
			else if(o.e < this.e) return 1;
			else
			{
				if(o.m < this.m) return -1;
				else if(o.m > this.m) return 1;
				else
				{
					String n1 = o.name, n2 = this.name;
					int alen = n1.length(), blen = n2.length();
					int len = Math.min(n1.length(), n2.length());
					for(int i = 0; i < len; i++)
					{
						int num1 = n1.charAt(i) - 'a';
						int num2 = n2.charAt(i) - 'a';
						if(num1 > num2) return -1;
						else if(num1 < num2) return 1;
					}
					
					if(alen > blen) return -1;
					else if(alen < blen) return 1;
					else return 0;
				}
			}
		}
		else return -1;
	}
}