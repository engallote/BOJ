import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<Sort> pq = new PriorityQueue<>();
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < N; i++)
		{
			String s = sc.next();
			hs.add(s);
		}
		
		Iterator<String> it = hs.iterator();
		
		while(it.hasNext())
		{
			String s = it.next();
//			System.out.println(s);
			pq.add(new Sort(s));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().s);
	}
}
class Sort implements Comparable<Sort>{
	String s;
	Sort(String s)
	{
		this.s = s;
	}
	@Override
	public int compareTo(Sort o) {
		if(o.s.length() > this.s.length()) return -1;
		else if(o.s.length() == this.s.length())
		{
			char[] a = o.s.toCharArray();
			char[] b = this.s.toCharArray();
			
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] - 'a' > b[i] - 'a') return -1;
				else if(a[i] - 'a' < b[i] - 'a') return 1;
			}
			return 0;
		}
		else return 1;
	}
}