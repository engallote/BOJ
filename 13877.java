import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			int test_case = sc.nextInt();
			int N = sc.nextInt();
			long sum = 0, num = N, cnt = 1;
			boolean e = true;
			while(num > 0)
			{
				sum += (num % 10) * cnt;
				if(num % 10 >= 8)
				{
					e = false;
					break;
				}
				cnt *= 8;
				num /= 10;
			}
			if(e) System.out.print(test_case + " " + sum + " " + N + " ");
			else System.out.print(test_case + " 0 " + N + " ");
			num = N;
			sum = 0;
			cnt = 1;
			while(num > 0)
			{
				sum += (num % 10) * cnt;
				cnt *= 16;
				num /= 10;
			}
			System.out.println(sum);
		}
	}
}