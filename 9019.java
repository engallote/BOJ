import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			boolean[] time = new boolean[10000];
			time[a] = true;
			
			Queue<Pair> q = new LinkedList<>();
			q.offer(new Pair(a, ""));
			
			while(!q.isEmpty())
			{
				Pair pair = q.poll();
				int p = pair.n;
				String s = pair.s;
				
				if(p == b)
				{
					System.out.println(s);
					break;
				}
				
				int num = p * 2 % 10000;
				if(!time[num])
				{
					q.offer(new Pair(num, s + "D"));
					time[num] = true;
				}
				num = p - 1;
				if(num < 0)
					num = 9999;
				if(!time[num])
				{
					q.offer(new Pair(num, s + "S"));
					time[num] = true;
				}
				num = (p % 1000) * 10 +  p / 1000;
				if(!time[num])
				{
					q.offer(new Pair(num, s + "L"));
					time[num] = true;
				}
				num = (p % 10) * 1000 + (p / 10);
				if(!time[num])
				{
					q.offer(new Pair(num, s + "R"));
					time[num] = true;
				}
			}
		}
	}
}
class Pair{
	int n;
	String s;
	Pair(int n, String s){
		this.n = n;
		this.s = s;
	}
}