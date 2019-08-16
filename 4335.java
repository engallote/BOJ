import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> h = new LinkedList<>(), l = new LinkedList<>();
        int N;
        boolean honest = true;
        while(true)
        {
        	N = sc.nextInt();
        	if(N == 0) break;
        	String pre = sc.next();
        	String ans = sc.next();
        	if(N > 10) honest = false;
        	if(ans.equals("high")) h.add(N);
        	else if(ans.equals("low")) l.add(N);
        	else if(ans.contains("on"))
        	{
        		while(!h.isEmpty())
        			if(h.poll() <= N)
        			{
        				honest = false;
        				break;
        			}
        		while(!l.isEmpty())
        			if(l.poll() >= N)
        			{
        				honest = false;
        				break;
        			}
        		if(honest)
        			System.out.println("Stan may be honest");
        		else
        			System.out.println("Stan is dishonest");
        		h.clear();
        		l.clear();
        		honest = true;
        	}
        }
	}
}