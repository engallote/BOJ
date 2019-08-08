import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res = 1;
		for(int i = a; i <= b; i++)
		{
			res *= (i * (i + 1)) / 2;
			res %= 14579;
		}
		System.out.println(res);
	}
}