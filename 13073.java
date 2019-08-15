import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			
			int sum1 = (N * (N + 1)) / 2, sum2 = 0, sum3 = 0;
			int cnt = 0;
			for(int i = 1; cnt < N; i+=2, cnt++)
				sum2 += i;
			cnt = 0;
			for(int i = 2; cnt < N; i+=2, cnt++)
				sum3 += i;
			System.out.println(sum1 + " " + sum2 + " " + sum3);
		}
	}
}