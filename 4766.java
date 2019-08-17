import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double res = 0;
		boolean start = false;
		while(true)
		{
			double N = sc.nextDouble();
			if(N == 999) break;
			if(!start)
			{
				start = true;
				res = N;
			}
			else
			{
				System.out.printf("%.2f\n", N - res);
				res = N;
			}
		}
	}
}