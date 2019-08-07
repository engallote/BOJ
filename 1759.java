import java.util.*;

public class Main {
	static int L, C;
	static char[] alp;
	static Vector<String> v = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		alp = new char[C];
		
		for(int i = 0; i < C; i++)
			alp[i] = sc.next().charAt(0);
		Arrays.sort(alp);
		
		for(int i = 0; i <= C - L; i++)
			solve(i, alp[i] + "");
		v.sort(null);
		for(String s : v)
			System.out.println(s);
	}
	private static void solve(int idx, String s) {
		if(s.length() == L)
		{
			if(!v.contains(s))
			{
				int mo = 0, za = 0;
				for(int i = 0; i < s.length(); i++)
				{
					if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
						mo++;
					else
						za++;
				}
				if(mo >= 1 && za >= 2)
					v.add(s);
			}
			
			return;
		}
		if(idx == C - 1) return;
		solve(idx+1, s + alp[idx+1]);
		solve(idx+1, s);
	}
}