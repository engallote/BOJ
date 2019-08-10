import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal A = new BigDecimal(sc.next());
		BigDecimal B = new BigDecimal(sc.next());
		int N = sc.nextInt();
		BigDecimal res = A.divide(B, N, BigDecimal.ROUND_DOWN);
		int idx = res.toString().indexOf('.');
		String res2 = res.toString().substring(idx+1);
//		System.out.println(res2);
		System.out.println(res2.charAt(N-1));
	}
}