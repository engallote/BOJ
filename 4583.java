import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Character> hs = new HashSet<>();
		hs.add('b');
		hs.add('d');
		hs.add('p');
		hs.add('q');
		hs.add('o');
		hs.add('i');
		hs.add('v');
		hs.add('w');
		hs.add('x');
		StringBuilder sb;
		while(true)
		{
			String s = sc.next();
			if(s.equals("#")) break;
			sb = new StringBuilder();
			for(char c : s.toCharArray())
			{
				if(!hs.contains(c)) break;
				if(c == 'b') sb.append('d');
				else if(c == 'd') sb.append('b');
				else if(c == 'p') sb.append('q');
				else if(c == 'q') sb.append('p');
				else sb.append(c);
			}
			sb.reverse();
			if(sb.toString().length() != s.length()) System.out.println("INVALID");
			else System.out.println(sb.toString());
		}
	}
}