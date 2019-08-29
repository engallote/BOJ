import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int K = sc.nextInt();
			if(K == 1)
				System.out.println(1);
			else
			{
				double sum = 1;
				
				for(int i = 1; i < K; i++)
				{
					sum += 0.5;
					sum *= 2;
				}
				System.out.println((int)sum);
			}
		}
	}
}