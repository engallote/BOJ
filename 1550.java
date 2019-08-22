import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int[] arr = new int[c.length];
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] >= 'A' && c[i] <= 'F')
				arr[i] = (c[i] - 'A') + 10;
			else
				arr[i] = c[i] - '0';
		}
		
		int sum = 0, x = 1;
		for(int i = c.length - 1; i >= 0; i--)
		{
			sum += (x * arr[i]);
			x *= 16;
		}
		
		System.out.println(sum);
	}
}