import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int M = sc.nextInt();//총월
			int M_D = sc.nextInt();//월당일수
			int D = sc.nextInt();//주당일수
			
			int r = 1, c = 0, d = 1, m = 1;
			
			while(m <= M)
			{
				d++;
				c++;
				if(c / D > 0) r++;
				c %= D;
				if(d > M_D)
				{
					if(m == M) break;
					m++;
					d = 1;
					if(c != 0)
						r++;
				}
				if(m == M && d == M_D) break;
//				System.out.println(m + " " + d + " : " + r + " " + c);
			}
			System.out.println("Case #" + test_case + ": " + r);
		}
	}
}