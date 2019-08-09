import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, Pair> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 1; j <= 3; j++)
			{
				int a = sc.nextInt();
				if(hs.containsKey(j))
				{
					Pair v = hs.get(j);
					int one = v.one, two = v.two, three = v.three;
					if(a == 1)
						one++;
					else if(a == 2)
						two++;
					else
						three++;
					hs.remove(j);
					hs.put(j, new Pair(three, two, one));
				}
				else
				{
					int one = 0, two = 0, three = 0;
					if(a == 1)
						one++;
					else if(a == 2)
						two++;
					else
						three++;
					hs.put(j, new Pair(three, two, one));
				}
			}
		}
		
		Set<Integer> st = hs.keySet();
		Iterator<Integer> it = st.iterator();
		int max = 0, thr = 0, two = 0, one = 0, num = 0, m3 = 0, m2 = 0;
		while(it.hasNext())
		{
			int key = it.next();
			Pair v = hs.get(key);
			one = v.one;
			two = v.two;
			thr = v.three;
			int sum = (thr * 3) + (two * 2) + one;
			if(sum > max)
			{
				max = sum;
				num = key;
				m2 = two;
				m3 = thr;
			}
			else if(sum == max)
			{
				if(m2 == two && m3 == thr)
				{
					num = 0;
				}
				else if(m3 < thr)
				{
					num = key;
					m3 = thr;
					m2 = two;
				}
				else if(m3 == thr && m2 < two)
				{
					num = key;
					m3 = thr;
					m2 = two;
				}
			}
		}
		
		System.out.println(num + " " + max);
	}
}
class Pair implements Comparable<Pair>{
	int  three, two, one;
	Pair(int three, int two, int one){
		this.three = three;
		this.two = two;
		this.one = one;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.three > this.three) return 1;
		else if(o.three < this.three) return -1;
		else
		{
			if(o.two > this.two) return 1;
			else if(o.two < this.two) return -1;
			else return 0;
		}
	}
}