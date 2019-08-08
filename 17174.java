import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int res = N;
		int num = N / M;
		while(num >= M)
		{
			res += num;
			num /= M;
		}
		res += num;
		System.out.println(res);
	}
}