import java.util.*;

public class Main {
	static int[] chk = new int[100001];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Str> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
		{
			String s = sc.next();
			int sum = 0;
			for(int j = 0; j < s.length(); j++)
				if(s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9)
					sum += s.charAt(j) - '0';
			pq.add(new Str(s, s.length(), sum));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().s);
	}
}
class Str implements Comparable<Str>{
	String s;
	int len, sum;
	Str(String s, int len, int sum){
		this.s = s;
		this.len = len;
		this.sum = sum;
	}
	@Override
	public int compareTo(Str o) {
		if(o.len < this.len) return 1;
		else if(o.len == this.len){
			if(o.sum > this.sum) return -1;
			else if(o.sum == this.sum)
			{
				for(int i = 0; i < o.len; i++)
				{
					if(o.s.charAt(i) - 'A' > this.s.charAt(i) - 'A') return -1;
					else if(o.s.charAt(i) - 'A' < this.s.charAt(i) - 'A') return 1;
				}
				return 0;
			}
			else return 1;
		}
		else return -1;
	}
}