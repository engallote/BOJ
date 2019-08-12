import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int d = sc.nextInt();
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			
			int ret1 = s * n, ret2 = d + (n * p);
			if(ret1 == ret2) System.out.println("does not matter");
			else if(ret1 < ret2) System.out.println("do not parallelize");
			else System.out.println("parallelize");
		}
	}
}