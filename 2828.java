import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int start = 1, end = M, ans = 0;
		
		for(int i = 0; i < K; i++)
		{
			int apple = sc.nextInt();
			
			if(apple > end)
			{
				ans += apple - end;
				end = apple;
				start = end - M + 1;
			}
			if(apple < start)
			{
				ans += start - apple;
				start = apple;
				end = start + M - 1;
			}
		}
		
		System.out.println(ans);
	}
}