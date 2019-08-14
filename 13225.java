import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int res = 0;
			
			for(int i = 1; i <= N; i++)
				if(N % i == 0) res++;
			System.out.println(N + " " + res);
		}
	}
}