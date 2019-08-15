import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long R = sc.nextLong();
		int[] arr = new int[10];
		
		while(L <= R)
		{
			long num = L;
			
			while(num > 0)
			{
				arr[(int)(num % 10)]++;
				num /= 10;
			}
			L++;
		}
		
		for(int i = 0; i < 10; i++)
			System.out.print(arr[i] + " ");
	}
}