import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int max = N;
			for(int i = 0; N > 1; i++)
			{
				if(N % 2 == 1)
				{
					N *= 3;
					N += 1;
				}
				else
					N /= 2;
				if(max < N)
					max = N;
			}
			System.out.println(max);
		}
	}
}