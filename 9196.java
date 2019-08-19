import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int h = sc.nextInt();
        	int w = sc.nextInt();
        	if(h == 0 && w == 0) break;
        	int len = (h * h) + (w * w);
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
    		for(int i = 1; i < 150; i++)
    		{
    			for(int j = i + 1; j <= 150; j++)
    			{
    				if(i == h && j == w) continue;
    				int d = (i * i) + (j * j);
    				if(d > len)
    					pq.add(new Pair(i, j));
    				else if(d == len && i > h)
    					pq.add(new Pair(i, j));
    			}
    		}
    		System.out.println(pq.peek().h + " " + pq.peek().w);
        }
	}
}
class Pair implements Comparable<Pair>{
	int h, w;
	Pair(int h, int w)
	{
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Pair o) {
		double d = Math.sqrt(Math.pow(o.h, 2) + Math.pow(o.w, 2));
		double d2 = Math.sqrt(Math.pow(this.h, 2) + Math.pow(this.w, 2));
		
		if(d < d2) return 1;
		else if(d > d2) return -1;
		else
		{
			if(o.h < this.h) return 1;
			else return -1;
		}
	}
}