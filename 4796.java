import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(true)
		{
			int L = sc.nextInt();
			int P = sc.nextInt();
			int V = sc.nextInt();
			if(L == 0 && P == 0 && V == 0) break;
			int mok = 0, mod = 0, res = 0;
			mok = V / P;
			mod = V % P;
			if(mod > L)
				mod = L;
			res = mok * L + mod;
			
			System.out.println("Case " + cnt + ": " + res);
			cnt++;
		}
	}
}
