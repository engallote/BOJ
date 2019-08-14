import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('A');
		hs.add('e');
		hs.add('E');
		hs.add('i');
		hs.add('I');
		hs.add('o');
		hs.add('O');
		hs.add('u');
		hs.add('U');
		
		for(int i = 1; i <= T; i++)
		{
			String str = sc.next();
			if(str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'Y')
				System.out.println("Case #" + i + ": " + str + " is ruled by nobody.");
			else if(hs.contains(str.charAt(str.length() - 1)))
				System.out.println("Case #" + i + ": " + str + " is ruled by a queen.");
			else
				System.out.println("Case #" + i + ": " + str + " is ruled by a king.");
		}
	}
}