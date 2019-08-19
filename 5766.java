import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	if(N == 0 && M == 0) break;
        	
        	HashMap<String, Integer> hs = new HashMap<>();
        	int max = 0;
        	for(int i = 0; i < N; i++)
        	{
        		for(int j = 0; j < M; j++)
        		{
        			String num = sc.next();
        			if(hs.containsKey(num))
        			{
        				int value = hs.get(num) + 1;
        				hs.remove(num);
        				hs.put(num, value);
        			}
        			else
        				hs.put(num, 1);
        			if(max < hs.get(num)) max = hs.get(num);
        		}
        	}
        	
        	Iterator<String> it = hs.keySet().iterator();
        	int nextMax = 0;
        	PriorityQueue<Integer> pq = new PriorityQueue<>();
        	while(it.hasNext())
        	{
        		String key = it.next();
        		int value = hs.get(key);
        		if(value > nextMax && value != max)
        		{
        			nextMax = value;
        			pq.clear();
        			pq.add(Integer.parseInt(key));
        		}
        		else if(value == nextMax)
        			pq.add(Integer.parseInt(key));
        	}
        	
        	while(!pq.isEmpty())
        		System.out.print(pq.poll() + " ");
        	System.out.println();
        }
    }
}