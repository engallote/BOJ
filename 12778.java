import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			char c = sc.next().charAt(0);
			
			if(c == 'C')
			{
				for(int i = 0; i < N; i++)
				{
					char ch = sc.next().charAt(0);
					System.out.print((ch-'A'+1) + " ");
				}
			}
			else
			{
				for(int i = 0; i < N; i++)
				{
					int num = sc.nextInt();
					System.out.print((char)(num - 1 + 'A') + " ");
				}
			}
			System.out.println();
		}
	}
}