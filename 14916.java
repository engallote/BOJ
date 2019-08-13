import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1) System.out.println(-1);
		else if(N % 5 == 0) System.out.println(N/5);
		else if(N % 5 == 2) System.out.println((N/5+1));
		else
		{
			int sum = 0, num = 0;
			while(num < N && (N - num) % 5 != 0)
			{
				sum++;
				num += 2;
			}
			if((N - num) % 5 == 0)
			{
				sum += (N - num) / 5;
				System.out.println(sum);
			}
			else System.out.println(-1);
		}
	}
}