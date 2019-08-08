import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int Quarter = 25, Dime = 10, Nickel = 5, Penny = 1;
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			int q = 0, d = 0, n = 0, p = 0;
			
			while(N > 0)
			{
				while(N / Quarter > 0)
				{
					q += N / Quarter;
					N %= Quarter;
				}
				while(N / Dime > 0)
				{
					d += N / Dime;
					N %= Dime;
				}
				while(N / Nickel > 0)
				{
					n += N / Nickel;
					N %= Nickel;
				}
				p += N;
				break;
			}
			
			System.out.println(q + " " + d + " " + n + " " + p);
		}
	}
}