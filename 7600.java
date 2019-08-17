import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			char[] c = sc.nextLine().toLowerCase().toCharArray();
			if(c[0] == '#') break;
			HashSet<Character> hs = new HashSet<>();
			for(char ch : c)
				if(ch >= 'a' && ch <= 'z') hs.add(ch);
			
			System.out.println(hs.size());
		}
	}
}