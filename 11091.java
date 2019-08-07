import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] c = sc.nextLine().toLowerCase().toCharArray();
			int[] alp = new int[26];
			HashSet<Character> hs = new HashSet<>();
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] >= 'a' && c[i] <= 'z')
				{
					alp[c[i]-'a'] = 1;
					hs.add(c[i]);
				}
			}
			
			if(hs.size() == 26) System.out.println("pangram");
			else
			{
				System.out.print("missing ");
				for(int i = 0; i < 26; i++)
					if(alp[i] == 0) System.out.print((char)(i + 'a'));
				System.out.println();
			}
		}
	}
}