import java.util.*;

public class Main {
	static int alen, blen, max;
	static char[] a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.next().toCharArray();
		b = sc.next().toCharArray();
		alen = a.length;
		blen = b.length;
		max = -1;
		solve("", 0, 0);
		System.out.println(max);
	}
	private static void solve(String num, int cnt, int chk) {
		if(cnt == alen)
		{
			if(num.charAt(0) == '0') return;
			if(Integer.parseInt(num) <= Integer.parseInt(new String(b)))
				max = Math.max(max, Integer.parseInt(num));
			return;
		}
		
		for(int i = 0; i < alen; i++)
			if((chk&(1<<i)) == 0)
				solve(num + a[i] + "", cnt + 1, chk|(1<<i));
	}
}