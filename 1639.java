import java.util.*;

public class Main {
	static int max = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		int cnt = 1;
		
		while(cnt < len)
		{
			solve(s, 0, cnt);
			cnt++;
		}
		System.out.println(max);
	}

	private static void solve(String s, int start, int cnt) {
		int len = start + cnt * 2;
		
		if(len > s.length())
			return;
		
		int count = 0, lsum = 0, rsum = 0;
		for(int i = start; i < len; i++)
		{
			if(count == cnt)
				rsum += s.charAt(i) - '0';
			
			else
			{
				lsum += s.charAt(i) - '0';
				count++;
			}
		}
		
		if(lsum == rsum)
			if(max < 2 * cnt)
				max = 2 * cnt;
		solve(s, start+1, cnt);
	}
}