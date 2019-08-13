import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			char[] c = sc.next().toCharArray();
			StringBuilder str = new StringBuilder();
			for(int i = 0; i < c.length; i++)
			{
				int num = c[i] - 'A';
				str.append((char)((a * num + b) % 26 + 'A'));
			}
			System.out.println(str.toString());
		}
	}
}