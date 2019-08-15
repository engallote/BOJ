import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		int max = 0;
		String ans = "";
		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			
			if(hs.containsKey(name))
			{
				hs.replace(name, hs.get(name) + 1);
				if(max < hs.get(name))
				{
					max = hs.get(name);
					ans = name;
				}
				else if(max == hs.get(name))
				{
					pq.clear();
					pq.offer(name);
					pq.offer(ans);
					
					ans = pq.poll();
				}
			}
			else 
			{
				hs.put(name, 1);
				if(max < 1)
				{
					max = 1;
					ans = name;
				}
			}
		}
		
		System.out.println(ans + " " + max);
	}
}