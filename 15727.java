import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int res = N / 5 + (N % 5 > 0 ? 1 : 0);
		System.out.println(res);
	}
}