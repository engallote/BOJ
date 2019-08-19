import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int res = Math.abs(b - a);
		int[] chk = new int[101];
		Arrays.fill(chk, 100000000);
		chk[a] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(a, 0));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.x == b)
			{
				res = Math.min(res, p.cnt);
				break;
			}
			
			if(chk[p.x + 1] > p.cnt + 1)
			{
				chk[p.x + 1] = p.cnt + 1;
				pq.offer(new Pair(p.x + 1, p.cnt + 1));
			}
			if(p.x - 1 >= 0 && chk[p.x - 1] > p.cnt + 1)
			{
				chk[p.x - 1] = p.cnt + 1;
				pq.offer(new Pair(p.x - 1, p.cnt + 1));
			}
			if(p.x == x && chk[y] > p.cnt)
			{
				chk[y] = p.cnt + 1;
				pq.offer(new Pair(y, p.cnt));
			}
			if(p.x == y && chk[x] > p.cnt)
			{
				chk[x] = p.cnt + 1;
				pq.offer(new Pair(x, p.cnt));
			}
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int x, cnt;
	Pair(int x, int cnt){
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}