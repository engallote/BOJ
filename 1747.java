import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] chk = new boolean[10000001];
		chk[0] = chk[1] = true;
		
		for(int i = 2; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= 10000000; j+=i)
				chk[j] = true;
		}
		
		for(int i = N; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			if(solve(i+""))
			{
				System.out.println(i);
				return;
			}
		}
	}

	private static boolean solve(String s) {
		StringBuilder str = new StringBuilder();
		str.append(s);
		str.reverse();
		return s.equals(str.toString());
	}
}