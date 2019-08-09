import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, Integer> hs = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int val = 0;
			if(!hs.containsKey(a))
				hs.put(a, val);
			else
				val = hs.get(a) + 1;

			if(hs.containsKey(b))
			{
				val += hs.get(b);
				hs.remove(b);
				hs.put(b, val + 1);
			}
			else if(!hs.containsKey(b))
				hs.put(b, val);
		}
		
		Set<Integer> st = hs.keySet();
		Iterator<Integer> it = st.iterator();
		
		while(it.hasNext())
		{
			int num = it.next();
			int val = hs.get(num);
//			System.out.println(num + " " + val);
			pq.add(new Pair(num, val));
		}
		
		while(!pq.isEmpty())
			System.out.print(pq.poll().num + " ");
	}
}
class Pair implements Comparable<Pair>{
	int num, cnt;
	Pair(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return -1;
		else if(o.cnt == this.cnt) return 0;
		else return 1;
	}
}