import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int Y = 0, K = 0;
			for(int i = 0; i < 9; i++)
			{
				int y = sc.nextInt();
				int k = sc.nextInt();
				if(y > k) Y++;
				else if(y < k) K++;
			}
			if(Y > K)
				System.out.println("Yonsei");
			else if(Y == K)
				System.out.println("Draw");
			else
				System.out.println("Korea");
		}
	}
}