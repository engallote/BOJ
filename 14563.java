import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			if(N == 1)
			{
				System.out.println("Deficient");
				continue;
			}
			int sum = 1;
			for(int i = 2; i < N; i++)
				if(N % i == 0) 
				{
//					System.out.println(i);
					sum += i;
				}
			
			if(sum == N)
				System.out.println("Perfect");
			else if(sum > N)
				System.out.println("Abundant");
			else
				System.out.println("Deficient");
		}
	}
}