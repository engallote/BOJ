import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int k = sc.nextInt();
		int h = sc.nextInt();
		
		if(s + k + h >= 100) System.out.println("OK");
		else
		{
			int min = Integer.MAX_VALUE;
			String who = "";
			if(min > s)
			{
				min = s;
				who = "Soongsil";
			}
			if(min > k)
			{
				min = k;
				who = "Korea";
			}
			if(min > h)
			{
				min = h;
				who = "Hanyang";
			}
			System.out.println(who);
		}
	}
}