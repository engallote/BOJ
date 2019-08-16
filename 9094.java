import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int tmp = 0, res = 0;
			for(int a = 1; a < n - 1; a++)
				for(int b = a + 1; b < n; b++)
				{
					tmp = ((a * a) + (b * b) + m) % (a * b);
					if(tmp == 0)
					{
//						System.out.println(a + ", " + b + " : " + tmp + "_" + tmp2);
						res++;
					}
				}
			System.out.println(res);
		}
	}
}