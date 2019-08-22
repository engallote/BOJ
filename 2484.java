import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			int sum = 0;
			HashMap<Integer, Integer> hs = new HashMap<>();
			for(int j = 0; j < 4; j++)
			{
				int num = sc.nextInt();
				if(hs.containsKey(num))
				{
					int v = hs.get(num);
					hs.remove(num);
					hs.put(num, v + 1);
				}
				else
					hs.put(num, 1);
			}
			
			Set<Integer> key = hs.keySet();
			Iterator<Integer> it = key.iterator();
			Vector<Integer> n = new Vector<>();
			int maxNum = 0;
			while(it.hasNext())
			{
				int k = it.next();
				int v = hs.get(k);
				if(v == 4)
				{
					sum = k * 5000 + 50000;
					break;
				}
				else if(v == 3)
				{
					sum = k * 1000 + 10000;
					break;
				}
				else if(v == 2)
					n.add(k);
				else
					maxNum = Math.max(maxNum, k);	
			}
			
			if(sum == 0)
			{
				if(n.size() == 1)
					sum = 100 * n.get(0) + 1000;
				else if(n.size() == 2)
					sum = 500 * n.get(0) + 500 * n.get(1) + 2000;
				else if(n.size() == 0)
					sum = maxNum * 100;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}