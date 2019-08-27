import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		hs.add(sc.nextInt());
		int cnt = 0;
		for(int i = 1; i < N; i++)
		{
			int a = sc.nextInt();
			if(!hs.contains(a))
				hs.add(a);
			else
				cnt++;
		}
		System.out.println(cnt);
	}
}