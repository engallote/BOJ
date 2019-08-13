import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.nextLine().toCharArray();
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < c.length; i++)
		{
			if(hs.contains(c[i]) && i + 2 < c.length && c[i+1] == 'p' && c[i+2] == c[i])
			{
				str.append(c[i]);
				i+=2;
				continue;
			}
			str.append(c[i]);
		}
		
		System.out.println(str.toString());
	}
}