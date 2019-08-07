import java.util.*;

public class Main {
	static int N;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int res = solve("", 0);
		System.out.println(res);
	}
	private static int solve(String key, int idx) {
		if(idx == N)
		{
			long num = Long.parseLong(key);
			hs.add(key);
			if(num != 0 && num % 3 == 0) return 1;
			return 0;
		}
		
		int ret = 0;
		if(idx != 0) ret += solve(key + "0", idx + 1);
		ret += solve(key + "1", idx + 1);
		ret += solve(key + "2", idx + 1);
		return ret;
	}
}