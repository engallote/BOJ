import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int op = sc.nextInt();
			int sum = N;
			for(int i = 0; i < op; i++)
			{
				int num = sc.nextInt();
				int pur = sc.nextInt();
				
				sum += (num * pur);
			}

			System.out.println(sum);
		}
	}
}