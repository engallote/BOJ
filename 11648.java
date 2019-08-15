import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(N >= 10)
		{
			int mul = 1, num = N;
			while(num > 0)
			{
				mul *= num % 10;
				num /= 10;
			}
			N = mul;
			cnt++;
		}
		System.out.println(cnt);
	}
}