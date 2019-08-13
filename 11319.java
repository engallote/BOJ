import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		hs.add('A');
		hs.add('E');
		hs.add('I');
		hs.add('O');
		hs.add('U');
		
		for(int i = 0; i < N; i++)
		{
			int a = 0, z = 0;
			char[] c = sc.nextLine().toCharArray();
			for(int j = 0; j < c.length; j++)
			{
				if(c[j] == ' ') continue;
				if(hs.contains(c[j])) a++;
				else z++;
			}
			
			System.out.println(z + " " + a);
		}
	}
}