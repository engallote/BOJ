import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++)
		{
			char[] ch = sc.next().toCharArray();
			HashSet<Character> hs = new HashSet<>();
			
			for(int i = 0; i < ch.length; i++)
				if(!hs.contains(ch[i]))
					hs.add(ch[i]);
			System.out.println(hs.size());
		}
	}
}