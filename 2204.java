import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
//			System.out.println(('a'-'0'));
//			System.out.println(('A'-'0'));
			PriorityQueue<Sort> pq = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++)
			{
				String s = sc.next();
				pq.add(new Sort(s));
			}
//			while(!pq.isEmpty())
//				System.out.println(pq.poll().s);
			System.out.println(pq.poll().s);
		}
	}
}
class Sort implements Comparable<Sort>{
	String s;
	Sort(String s){
		this.s = s;
	}
	@Override
	public int compareTo(Sort o) {
		String tmp1 = o.s.toLowerCase();
		String tmp2 = this.s.toLowerCase();
		char[] a = tmp1.toCharArray();
		char[] b = tmp2.toCharArray();
		
		int len = Math.min(a.length, b.length);
		for(int i = 0; i < len; i++)
		{
			if(a[i] - 'a' > b[i] - 'a') return -1;
			else if(a[i] == b[i]) continue;
			else return 1;
		}
		if(a.length == b.length) return 0;
		else if(a.length < b.length) return 1;
		else return -1;
	}
}