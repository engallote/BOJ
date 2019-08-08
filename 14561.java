import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long A = sc.nextLong();
			int N = sc.nextInt();
			
			String num = Long.toString(A, N);
			StringBuilder sb = new StringBuilder();
			sb.append(num);
			sb.reverse();
			
			if(num.equals(sb.toString()))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}