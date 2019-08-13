import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] c = sc.nextLine().toCharArray();
			int res = 0;
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == 'A' || c[i] == 'D' || c[i] == 'O' || c[i] == 'P' || c[i] == 'Q' || c[i] == 'R')
					res++;
				else if(c[i] == 'B') res += 2;
			}
			System.out.println(res);
		}
	}
}