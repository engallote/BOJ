import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
			HashSet<Long> hs = new HashSet<>();
			if(N == 0)
			{
				System.out.println("Case #" + test_case + ": INSOMNIA");
				continue;
			}
			long res = 0;
			for(int i = 1;; i++)
			{
				long num = N * i;
				
				while(num > 0)
				{
					hs.add(num % 10);
					num /= 10;
				}
				if(hs.size() == 10)
				{
					res = N * i;
					break;
				}
			}
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
}