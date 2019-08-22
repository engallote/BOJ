import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int G = sc.nextInt();
        int[] chk = new int[1000000];
        Arrays.fill(chk, 1000000000);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(N, 0));
        
        while(!pq.isEmpty())
        {
        	Pair p = pq.poll();
        	if(p.num == G)
        	{
        		System.out.println(p.cnt);
        		return;
        	}
        	
        	if(p.cnt + 1 <= T)
        	{
        		if(chk[p.num + 1] > p.cnt + 1)
        		{
        			chk[p.num+1] = p.cnt + 1;
        			pq.add(new Pair(p.num + 1, p.cnt + 1));
        		}
        		if(p.num != 0 && p.num * 2 <= 99999)
        		{
        			int num = p.num * 2;
        			String tmp = Integer.toString(num);
        			num = 0;
        			for(int j = 0; j < tmp.length(); j++)
        			{
        				if(j == 0)
        					num += (tmp.charAt(j) - '0') - 1;
        				else
        					num += (tmp.charAt(j) - '0');
        				if(j != tmp.length()-1)
        					num *= 10;
        			}
        			if(chk[num] > p.cnt + 1)
        			{
        				chk[num] = p.cnt + 1;
        				pq.add(new Pair(num, p.cnt + 1));
        			}
        		}
        	}
        }
        System.out.println("ANG");
    }
}
class Pair implements Comparable<Pair>{
	int num, cnt;
	Pair(int num, int cnt)
	{
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}