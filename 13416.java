import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			int max = 0, res = 0;
			
			for(int i = 0; i < N; i++)
			{
				max = 0;
				for(int j = 0; j < 3; j++)
				{
					int num = sc.nextInt();
					if(num > max) max = num;
				}
//				System.out.println(">> " + max + " " + cnt);
				res += max;
			}
			System.out.println(res);
		}
	}
}