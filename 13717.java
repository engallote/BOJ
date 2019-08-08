import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		int max = 0, sum = 0;
		String res = "";
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String name = sc.next();
			
			int K = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0, tmp = 0;
			while(M >= K)
			{
				tmp = M / K;
				cnt += tmp;
				M %= K;
				M += (tmp * 2);
			}
			hs.put(name, cnt);
			if(hs.get(name) > max)
			{
				max = hs.get(name);
				res = name;
			}
			sum += hs.get(name);
		}
		System.out.println(sum);
		System.out.println(res);
	}
}