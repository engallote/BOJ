import java.util.*;

public class Main {
	static long N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		M = sc.nextLong();
		if(N == M)
		{
			System.out.println(0);
			return;
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(N, ""));
		HashSet<Long> hs = new HashSet<>();
		hs.add(N);
		String res = "-1";
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.num == M)
				{
					res = p.op;
					q.clear();
					break;
				}
				if(p.num * p.num <= M && !hs.contains(p.num * p.num))
				{
					hs.add(p.num * p.num);
					q.add(new Pair(p.num * p.num, p.op + "*"));
				}
				if(p.num + p.num <= M && !hs.contains(p.num + p.num))
				{
					hs.add(p.num + p.num);
					q.add(new Pair(p.num + p.num, p.op + "+"));
				}
				if(p.num - p.num > 0 && !hs.contains(p.num - p.num))
				{
					hs.add(p.num - p.num);
					q.add(new Pair(p.num - p.num, p.op + "-"));
				}
				if(p.num / p.num > 0 && !hs.contains(p.num / p.num))
				{
					hs.add(p.num / p.num);
					q.add(new Pair(p.num / p.num, p.op + "/"));
				}
			}
		}
		System.out.println(res);
	}
}
class Pair{
	long num;
	String op;
	Pair(long num, String op){
		this.num = num;
		this.op = op;
	}
}