import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	String[][] change = new String[N][2];
        	hs.clear();
        	for(int i = 0; i < N; i++)
        	{
        		change[i][0] = sc.next();
        		change[i][1] = sc.next();
        	}
        	
        	String start = sc.next();
        	String end = sc.next();
        	hs.add(start);
        	int res = -1;
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	pq.add(new Pair(start, 0));
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		
        		if(p.str.length() > end.length()) continue;
        		if(p.str.equals(end))
        		{
        			res = p.cnt;
        			break;
        		}
        		
        		String str;
        		
        		for(int k = 0; k < N; k++)
        		{
            		str = p.str;
            		str = str.replaceAll(change[k][0], change[k][1]);
            		if(!hs.contains(str)){
            			hs.add(str);
            			pq.add(new Pair(str, p.cnt + 1));
            		}
        		}
        	}
        	System.out.println(res);
        }
	}
}
class Pair implements Comparable<Pair>{
	String str;
	int cnt;
	Pair(String str, int cnt)
	{
		this.str = str;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}