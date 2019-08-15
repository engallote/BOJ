import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long H = sc.nextLong();
		long W = sc.nextLong();
		long N = sc.nextLong();
		
		long div1 = H / N + ((H % N != 0) ? 1 : 0);
		long div2 = W / N + ((W % N != 0) ? 1 : 0);
		
		long res = div1 * div2;
		System.out.println(res);
	}
}