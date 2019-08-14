import java.util.*;

public class Main {
	static long N, len, sub = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		len = Long.toString(N).length();
		
		if(len > 10)
			System.out.println("9876543210");
		else
		{
			solve(0, "", 0);
			System.out.println(res);
		}
	}
	private static void solve(int idx, String number, int chk) {
		if(idx > 0)
		{
			long num = Long.parseLong(number);
			if(Math.abs(N - num) <= sub)
			{
				if(sub == Math.abs(N - num)) res = Math.min(res, num);
				else
				{
					sub = Math.abs(N - num);
					res = num;
				}
			}
		}
		if(idx == len) return;
		for(int i = 0; i < 10; i++)
			if((chk&(1<<i)) == 0)
				solve(idx + 1, number + i + "", chk|(1<<i));
	}
}