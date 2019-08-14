import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long m = sc.nextLong();
		
		for(int i = 1; i <= 10000; i++)
		{
			long num = m * i + 1;
			if(num % a == 0)
			{
				System.out.println(num/a);
				break;
			}
		}
	}
}