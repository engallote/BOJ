import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<String> pq = new PriorityQueue<>();
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < N; i++)
        	hs.add(sc.next());
        for(int i = 0; i < M; i++)
        {
        	String s = sc.next();
        	if(hs.contains(s))
        		pq.add(s);
        }
        
        System.out.println(pq.size());
        while(!pq.isEmpty())
        System.out.println(pq.poll());
    }
}