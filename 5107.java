import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	HashMap<String, Integer> hs = new HashMap<>();
        	ArrayList<Integer>[] arr = new ArrayList[N];
        	for(int i = 0; i < N; i++)
        		arr[i] = new ArrayList<>();
        	
        	int idx = 0;
        	for(int i = 0; i < N; i++)
        	{
        		String a = sc.next();
        		String b = sc.next();
        		
        		if(!hs.containsKey(a))
        			hs.put(a, idx++);
        		if(!hs.containsKey(b))
        			hs.put(b, idx++);
        		arr[hs.get(a)].add(hs.get(b));
        	}
        	int res = 0;
        	boolean[] chk = new boolean[N];
        	Queue<Integer> q = new LinkedList<>();
        	for(int i = 0; i < N; i++)
        	{
        		if(chk[i]) continue;
        		q.clear();
        		q.add(i);
        		while(!q.isEmpty())
        		{
        			int x = q.poll();
        			if(x == i && chk[x])
        			{
        				res++;
        				break;
        			}
        			for(int next : arr[x])
        				if(!chk[next])
        				{
        					chk[next] = true;
        					q.add(next);
        				}
        		}
        	}
        	System.out.println(tc + " " + res);
        	tc++;
        }
    }
}