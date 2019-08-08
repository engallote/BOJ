import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		while(true)
		{
			String s = sc.next();
			if(s.equals("end")) break;
			
			char[] c = s.toCharArray();
			int mo = 0, za = 0, len = c.length;
			char pre = '.';
			boolean flag = true, moum = false;
			
			for(int i = 0; i < len; i++)
			{
				if(pre == c[i])
				{
					if(c[i] == 'e' || c[i] == 'o')
					{
						if(mo + 1 < 3) mo++;
						else flag = false;
					}
					else flag = false;
				}
				else
				{
					pre = c[i];
					if(hs.contains(c[i]))
					{
						moum = true;
						za = 0;
						if(mo + 1 < 3) mo++;
						else flag = false;
					}
					else
					{
						mo = 0;
						if(za + 1 < 3) za++;
						else flag = false;
					}
				}
				
				if(!flag) break;
			}
			if(flag && moum)
				System.out.println("<" + s + "> is acceptable.");
			else
				System.out.println("<" + s + "> is not acceptable.");
		}
	}
}