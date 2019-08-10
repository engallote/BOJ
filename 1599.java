import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int t = 0; t < N; t++)
		{
			String s = sc.next();
			char[] ch = s.toCharArray();
			String num = "";
			int idx = 0;
			while(idx < ch.length)
			{
				if(ch[idx] == 'a')
					num += "1 ";
				else if(ch[idx] == 'b')
					num += "2 ";
				else if(ch[idx] == 'k')
					num += "3 ";
				else if(ch[idx] == 'd')
					num += "4 ";
				else if(ch[idx] == 'e')
					num += "5 ";
				else if(ch[idx] == 'g')
					num += "6 ";
				else if(ch[idx] == 'h')
					num += "7 ";
				else if(ch[idx] == 'i')
					num += "8 ";
				else if(ch[idx] == 'l')
					num += "9 ";
				else if(ch[idx] == 'm')
					num += "10 ";
				else if(ch[idx] == 'n')
				{
					if(idx+1 < ch.length && ch[idx+1] == 'g')
						num += "12 ";
					else
						num += "11 ";
				}
				else if(ch[idx] == 'o')
					num += "13 ";
				else if(ch[idx] == 'p')
					num += "14 ";
				else if(ch[idx] == 'r')
					num += "15 ";
				else if(ch[idx] == 's')
					num += "16 ";
				else if(ch[idx] == 't')
					num += "17 ";
				else if(ch[idx] == 'u')
					num += "18 ";
				else if(ch[idx] == 'w')
					num += "19 ";
				else if(ch[idx] == 'y')
					num += "20 ";
				idx++;
			}
			num = num.trim();
			pq.add(new Pair(s, num));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().str);
	}
}
class Pair implements Comparable<Pair>{
	String str, num;
	Pair(String str, String num)
	{
		this.str = str;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		String[] num1 = o.num.split(" "), num2 = this.num.split(" ");
		int len = Math.min(num1.length, num2.length);
		for(int i = 0; i < len; i++)
		{
			int one = Integer.parseInt(num1[i]);
			int two = Integer.parseInt(num2[i]);
			if(one > two)
				return -1;
			else if(one < two)
				return 1;
			else continue;
		}
		if(num1.length > num2.length) return -1;
		else if(num1.length == num2.length) return 0;
		else return 1;
	}
}