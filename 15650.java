import java.util.*;

public class Main {
	static int N, M;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        solve("", 1, 0);
        PriorityQueue<String> pq = new PriorityQueue<>();
        Iterator<String> it = hs.iterator();
        while(it.hasNext())
        	pq.add(it.next());
        
        while(!pq.isEmpty())
        	System.out.println(pq.poll());
    }
	private static void solve(String s, int num, int len) {
		if(len == M)
		{
			s = s.trim();
			hs.add(s);
			return;
		}
		if(num > N) return;
		if(len + 1 <= M)
			solve(s + num + " ", num + 1, len + 1);
		solve(s, num+1, len);
	}
}