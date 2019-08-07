import java.util.*;

public class Main {
	static final long mod = 1000000000000000000l;
	static HashMap<Double, Long> hs = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hs.put(0.0, 1l);
		hs.put(1.0, 1l);
		hs.put(2.0, 1l);
		hs.put(3.0, 1l);
		
		long res = solve(N);
		System.out.println(res);
	}
	private static long solve(double n) {
		if(n < 0) return 0;
		if(n <= Math.PI) return 1;
		if(hs.containsKey(n)) return hs.get(n) % mod;
		long ret = (solve(n - 1) % mod + solve(n - Math.PI) % mod) % mod;
		hs.put(n, ret);
		return hs.get(n);
	}
}