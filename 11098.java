import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			
			long max = 0;
			String name = "";
			for(int i = 0; i < N; i++)
			{
				long cost = sc.nextLong();
				String s = sc.next();
				
				if(cost > max)
				{
					max = cost;
					name = s;
				}
			}
			
			System.out.println(name);
		}
	}
}