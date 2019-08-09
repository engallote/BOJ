import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int n = a, cnt = 1;
		
		if(a >= k)
		{
			if(d < 0)
			{
				while(n > k)
				{
					n += d;
					cnt++;
				}
			}
		}
		else
		{
			if(d > 0)
			{
				while(n < k)
				{
					n += d;
					cnt++;
				}
			}
		}
		if(n == k)
			System.out.println(cnt);
		else
			System.out.println("X");
	} 
}