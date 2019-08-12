import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] c = sc.next().toCharArray();
			int len = 16, sum = 0;
			
			for(int i = len - 1; i >= 0; i--)
			{
				if(i % 2 == 0)
				{
					int num = c[i] - '0';
					num *= 2;
					int tmp = 0;
					while(num > 0)
					{
						tmp += num % 10;
						num /= 10;
					}
					sum += tmp;
				}
				else
					sum += (c[i] - '0');
			}
			
			if(sum % 10 == 0) System.out.println("T");
			else System.out.println("F");
		}
	}
}