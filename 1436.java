import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 6;
		for(int i = 1; i <= N; i++)
		{
			if(check(start)) start++;
			else
			{
				while(!check(start))
					start++;
				start++;
			}
		}
		
		System.out.println(start-1);
	}
	private static boolean check(int start) {
		int cnt = 0;
		String n = Integer.toString(start);
		for(int i = 0; i < n.length(); i++)
		{
			if(n.charAt(i) - '0' == 6) cnt++;
			else cnt = 0;
			if(cnt == 3) return true;
		}
		return false;
	}
}