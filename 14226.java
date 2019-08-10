import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		boolean[][] chk = new boolean[1001][1001];
		chk[1][0] = true;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1, 0, 0));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.num == S)
			{
				System.out.println(p.cnt);
				return;
			}
			
			if(p.num != p.clip && !chk[p.num][p.num])
			{
				chk[p.num][p.num] = true;
				pq.add(new Pair(p.num, p.cnt + 1, p.num));
			}
			if(p.num + p.clip <= 1000 && !chk[p.num + p.clip][p.clip])
			{
				chk[p.num + p.clip][p.clip] = true;
				pq.add(new Pair(p.num + p.clip, p.cnt + 1, p.clip));
			}
			if(p.num - 1 >= 1 && !chk[p.num - 1][p.clip])
			{
				chk[p.num - 1][p.clip] = true;
				pq.add(new Pair(p.num - 1, p.cnt + 1, p.clip));
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int num, cnt, clip;
	Pair(int num, int cnt, int clip){
		this.num = num;
		this.cnt = cnt;
		this.clip = clip;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}