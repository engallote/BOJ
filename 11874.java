import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int D = sc.nextInt();
		int X = sc.nextInt();
		
		int min = Integer.MAX_VALUE, max = 0, sum = 0, num = 0;
		for(int i = L; i <= D; i++)
		{
			num = i;
			sum = 0;
			while(num > 0)
			{
				sum += num % 10;
				num /= 10;
			}
			
			if(sum == X)
			{
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
		}
		System.out.println(min);
		System.out.println(max);
	}
}