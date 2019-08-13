import java.util.*;

public class Main {
	static int N, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int B1 = 0, W1 = 0, B2 = 0, W2 = 0, cnt = 0;
			for(int i = 0; i < N; i++)
			{
				if(a[i] == 'B') B1++;
				else W1++;
				if(b[i] == 'B') B2++;
				else W2++;
				if(a[i] != b[i]) cnt++;
			}
			if(B1 == B2 && W1 == W2)
				System.out.println(cnt / 2);
			else
			{
				int sub = 0;
				if(B1 == 0 || B2 == 0 || W1 == 0 || W2 == 0)
					System.out.println(cnt);
				else
				{
					sub = cnt - Math.abs(B1 - B2);
//					System.out.println("> " + cnt + ", " + Math.abs(B1 - B2));
					System.out.println(Math.abs(B1-B2) + (sub / 2));
				}
			}
		}
	}
}