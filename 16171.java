import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		String keyword = sc.next();
		int len = c.length, len2 = keyword.length();
		HashSet<String> hs = new HashSet<>();
		StringBuilder str;
		for(int i = 0; i < len; i++)
		{
			if(c[i] >= '0' && c[i] <= '9') continue;
			str = new StringBuilder();
			str.append(c[i]);
			if(str.toString().length() == len2)
			{
				hs.add(str.toString());
				continue;
			}
			for(int j = i + 1; j < len; j++)
			{
				if(c[j] >= '0' && c[j] <= '9') continue;
				str.append(c[j]);
				if(str.toString().length() == len2)
				{
					hs.add(str.toString());
					break;
				}
			}
		}
		
		if(hs.contains(keyword)) System.out.println(1);
		else System.out.println(0);
	}
}