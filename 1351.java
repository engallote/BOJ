import java.util.*;

public class Main {
	static long N, P, Q;
	static HashMap<Long, Long> hs = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		hs.put(0l, 1l);
		
		long res = solve(N);
		System.out.println(res);
	}
	private static long solve(long n) {
		if(hs.containsKey(n)) return hs.get(n);
		
		long ret = solve(n/P) + solve(n/Q);
		hs.put(n, ret);
		return ret;
	}
}