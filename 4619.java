import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int B = sc.nextInt();
			int N = sc.nextInt();
			if(B == 0 && N == 0) break;
			int min = Integer.MAX_VALUE, res = 0;
			if(N == 1)
			{
				System.out.println(B);
				continue;
			}
			for(int i = 0; i <= Math.sqrt(B); i++)
			{
				int mul = (int)Math.pow(i, N);
				if(Math.abs(mul - B) < min)
				{
					min = Math.abs(mul - B);
					res = i;
				}
			}
			System.out.println(res);
		}
	}
}