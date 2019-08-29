import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int sum = 0;
			for(int i = 0; i < N; i++)
			{
				int a = sc.nextInt();
				sum += (a / K);
			}
			
			System.out.println(sum);
		}
	}
}