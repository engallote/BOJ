import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			String[] s = sc.next().split("-");
			int num = Integer.parseInt(s[1]);
			int len = 2, sum = 0;
			
			for(int j = 0; j < 3; j++)
			{
				sum += (s[0].charAt(j) - 'A') * (int)Math.pow(26, len);
				len--;
			}
			System.out.println(Math.abs(num - sum) <= 100 ? "nice" : "not nice");
		}
	}
}