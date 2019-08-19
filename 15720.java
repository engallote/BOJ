import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int res = 0, preRes = 0, num;
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> c = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> d = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < B; i++)
		{
			num = sc.nextInt();
			preRes += num;
			b.offer(num);
		}
		for(int i = 0; i < C; i++)
		{
			num = sc.nextInt();
			preRes += num;
			c.offer(num);
		}
		for(int i = 0; i < D; i++) 
		{
			num = sc.nextInt();
			preRes += num;
			d.offer(num);
		}
		
		while(!b.isEmpty() && !c.isEmpty() && !d.isEmpty())
		{
			int tb = b.poll(), tc = c.poll(), td = d.poll();
			
			tb *= 0.9;
			tc *= 0.9;
			td *= 0.9;
			
			res += tb + tc + td;
		}
		
		while(!b.isEmpty()) res += b.poll();
		while(!c.isEmpty()) res += c.poll();
		while(!d.isEmpty()) res += d.poll();
		
		System.out.println(preRes);
		System.out.println(res);
	}
}