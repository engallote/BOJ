import java.util.*;

public class Main {
	static HashSet<String> hs = new HashSet<>();
	static int len, cnt = 0;
	static int[] alp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		len = c.length;
		alp = new int[26];
		boolean flag = true;
		for(int i = 1; i < c.length; i++)
			if(c[i-1] == c[i])
			{
				flag = false;
				break;
			}
		if(flag)
		{
			cnt = 1;
			hs.add(s);
		}
		for(int i = 0; i < c.length; i++)
			alp[c[i] - 'a']++;
		
		for(int i = 0; i < 26; i++)
			if(alp[i] > 0)
			{
				alp[i]--;
				solve((char)(i + 'a')+"");
				alp[i]++;
			}
		System.out.println(cnt);
	}
	private static void solve(String s) {
		
		for(int i = 0; i < 26; i++)
		{
			if(alp[i] > 0 && s.charAt(s.length() - 1) - 'a' != i)
			{
				alp[i]--;
				solve(s+(char)(i+'a'));
				alp[i]++;
			}
		}
		
		if(s.length() == len && !hs.contains(s))
			if(check(s))
			{
//				System.out.println(s);
				cnt++;
			}
	}
	private static boolean check(String s) {
		for(int i = 1; i <len; i++)
			if(s.charAt(i-1) == s.charAt(i))
			{
				return false;
			}
		return true;
	}
}