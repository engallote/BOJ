import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int C = sc.nextInt();
        	int res = (N / C) + (N % C > 0 ? 1 : 0);
        	System.out.println(res);
        }
	}
}