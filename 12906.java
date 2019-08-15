import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = "", b = "", c = "";
		int[] alp = new int[3];
		for(int i = 0; i < 3; i++)
		{
			int num = sc.nextInt();
			if(num > 0)
			{
				if(i == 0)
				{
					a = sc.next();
					for(char ch : a.toCharArray()) alp[ch-'A']++;
				}
				else if(i == 1)
				{
					b = sc.next();
					for(char ch : b.toCharArray()) alp[ch-'A']++;
				}
				else
				{
					c = sc.next();
					for(char ch : c.toCharArray()) alp[ch-'A']++;
				}
			}
		}
		
		String ans = "", key = "";
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < alp[i]; j++)
				ans += "" + (char)(i + 'A');
			if(i <= 1) ans += ",";
		}
		
		HashSet<String> hs = new HashSet<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(a, b, c, 0));
		hs.add(a + "," + b + "," + c);
//		System.out.println("> " + ans);
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			String res = p.a + "," + p.b + "," + p.c;
//			System.out.println(res);
			if(res.equals(ans))
			{
				System.out.println(p.cnt);
				return;
			}
			
			if(p.a.length() > 0)
			{
				char ch = p.a.charAt(p.a.length() - 1);
				String tmp = "";
				for(int i = 0; i < p.a.length() - 1; i++) tmp += "" + p.a.charAt(i);
				key = tmp + "," + p.b + "" + ch + "," + p.c;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("a -> b : " + key);
					pq.offer(new Pair(tmp, p.b + "" + ch, p.c, p.cnt + 1));
				}
				key = tmp + "," + p.b + "," + p.c + "" + ch;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("a -> c : " + key);
					pq.offer(new Pair(tmp, p.b, p.c + "" + ch, p.cnt + 1));
				}
			}
			if(p.b.length() > 0)
			{
				char ch = p.b.charAt(p.b.length() - 1);
				String tmp = "";
				for(int i = 0; i < p.b.length() - 1; i++) tmp += "" + p.b.charAt(i);
				key = p.a + "" + ch + "," + tmp + "," + p.c;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("b -> a : " + key);
					pq.offer(new Pair(p.a + "" + ch, tmp, p.c, p.cnt + 1));
				}
				key = p.a + "," + tmp + "," + p.c + "" + ch;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("b -> c : " + key);
					pq.offer(new Pair(p.a, tmp, p.c + "" + ch, p.cnt + 1));
				}
			}
			if(p.c.length() > 0)
			{
				char ch = p.c.charAt(p.c.length() - 1);
				String tmp = "";
				for(int i = 0; i < p.c.length() - 1; i++) tmp += "" + p.c.charAt(i);
				key = p.a + "" + ch + "," + p.b + "," + tmp;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("c -> a : " + key);
					pq.offer(new Pair(p.a + "" + ch, p.b, tmp, p.cnt + 1));
				}
				key = p.a + "," + p.b + "" + ch + "," + tmp;
				if(!hs.contains(key))
				{
					hs.add(key);
//					System.out.println("c -> b : " + key);
					pq.offer(new Pair(p.a, p.b + "" + ch, tmp, p.cnt + 1));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	String a, b, c;
	int cnt;
	Pair(String a, String b, String c, int cnt){
		this.a = a;
		this.b = b;
		this.c = c;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}