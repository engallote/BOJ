import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "bkxznhdcwgpvjqtsrlmf", m = "aiyeou";
		String ss = s.toUpperCase(), mm = m.toUpperCase();	
		char[] m2 = {'a', 'i', 'y', 'e', 'o', 'u'}, z2 = s.toCharArray(); 
		char[] m1 = mm.toCharArray(), z1 = ss.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNext())
		{
			char[] c = sc.nextLine().toCharArray();
			for(int i = 0; i < c.length; i++)
			{
				int idx = 0;
				if(mm.contains(c[i]+""))
				{
					idx = mm.indexOf(c[i]) - 3;
					if(idx < 0) idx = mm.length() + idx;
					sb.append(m1[idx]);
				}
				else if(ss.contains(c[i]+""))
				{
					idx = ss.indexOf(c[i]) - 10;
					if(idx < 0) idx = ss.length() + idx;
					sb.append(z1[idx]);
				}	
				else if(m.contains(c[i]+""))//¸ðÀ½
				{
					idx = m.indexOf(c[i]) - 3;
					if(idx < 0) idx = m.length() + idx;
					sb.append(m2[idx]);
				}
				else if(s.contains(c[i]+""))
				{
					idx = s.indexOf(c[i]) - 10;
					if(idx < 0) idx = s.length() + idx;
					sb.append(z2[idx]);
				}
				else sb.append(c[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}