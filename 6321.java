import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int t = 1; t <= N; t++)
		{
			char[] c = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == 'Z') sb.append('A');
				else sb.append((char)(c[i]+1));
			}
			System.out.println("String #" + t);
			System.out.println(sb.toString());
			System.out.println();
		}
	}
}