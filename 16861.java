import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		for(long i = N;; i++)
		{
			long num = i, sum = 0;
			while(num > 0)
			{
				sum += num % 10;
				num /= 10;
			}
			
			if(i % sum == 0)
			{
				System.out.println(i);
				break;
			}
		}
	}
}