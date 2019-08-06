import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		hs.add("0,0");
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		int time = 0;
		
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for(int i = 0; i < size; i++)
			{
				Pair p = q.poll();
				
				if(p.a == A && p.b == B)
				{
					System.out.println(time);
					return;
				}
				if(!hs.contains(a+","+p.b))// fill a
				{
					hs.add(a+","+p.b);
					q.add(new Pair(a, p.b));
				}
				if(!hs.contains(p.a+","+b))// fill b
				{
					hs.add(p.a+","+b);
					q.add(new Pair(p.a, b));
				}
				if(!hs.contains("0,"+p.b))// empty a
				{
					hs.add("0,"+p.b);
					q.add(new Pair(0, p.b));
				}
				if(!hs.contains(p.a+",0"))// empty b
				{
					hs.add(p.a+",0");
					q.add(new Pair(p.a, 0));
				}
				//move water from a to b
				if(p.a + p.b >= b)
				{
					int num = p.a - (b - p.b);
					if(!hs.contains(num+","+b))
					{
						hs.add(num+","+b);
						q.add(new Pair(num, b));
					}
				}
				if(p.a + p.b < b)
				{
					if(!hs.contains("0,"+(p.a+p.b)))
					{
						hs.add("0,"+(p.a+p.b));
						q.add(new Pair(0, (p.a+p.b)));
					}
				}
				//move water from b to a
				if(p.a + p.b >= a)
				{
					int num = p.b - (a - p.a);
					if(!hs.contains(a+","+num))
					{
						hs.add(a+","+num);
						q.add(new Pair(a, num));
					}
				}
				if(p.a + p.b < a)
				{
					if(!hs.contains((p.a+p.b)+",0"))
					{
						hs.add((p.a+p.b)+",0");
						q.add(new Pair((p.a+p.b), 0));
					}
				}
			}
			time++;
		}
		System.out.println(-1);
	}
}
class Pair{
	int a, b;
	Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}