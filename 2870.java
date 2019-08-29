import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Sort> p = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
		{
			String s = sc.next();
			String num = "";
			for(int j = 0; j < s.length(); j++)
			{
				if(s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9)
					num += s.charAt(j);
				else if(s.charAt(j) - '0' < 0 || s.charAt(j) - '0' > 9)
					if(num.length() > 0)
					{
						while(num.length() > 0 && num.charAt(0) - '0' == 0)
							num = num.replaceFirst("0", "");
						if(num.length() == 0)
							num = "0";
						p.add(new Sort(num));
						num = "";
					}
			}
			if(num.length() > 0)
			{
				while(num.length() > 0 && num.charAt(0) -'0' == 0)
					num = num.replaceFirst("0", "");
				if(num.length() == 0)
					num = "0";
				p.add(new Sort(num));
			}
		}
		
		while(!p.isEmpty())
			System.out.println(p.poll().s);
	}
}
class Sort implements Comparable<Sort>{
	String s;
	Sort(String s)
	{
		this.s = s;
	}
	@Override
	public int compareTo(Sort o) {
		if(this.s.length() > o.s.length())
			return 1;
		else if(this.s.length() == o.s.length())
		{
			int cnt = 0;
			for(int i = 0; i < this.s.length(); i++)
			{
				if(this.s.charAt(i) > o.s.charAt(i))
				{
					cnt = 1;
					break;
				}
				else if(this.s.charAt(i) < o.s.charAt(i))
				{
					cnt = 2;
					break;
				}
			}
			if(cnt == 0)
				return 0;
			else if(cnt == 1)
				return 1;
			else
				return -1;
		}
		else
			return -1;
	}
}