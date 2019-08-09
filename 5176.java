import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++)
		{
			int P = sc.nextInt();
			int M = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < P; i++)
			{
				int n = sc.nextInt();
				if(!hs.contains(n))
					hs.add(n);
			}
			System.out.println(P - hs.size());
		}
	}
}