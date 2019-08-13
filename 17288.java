import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int cnt = 1, res = 0;
		for(int i = 1; i < c.length; i++)
		{
			if(c[i-1] + 1 == c[i]) cnt++;
			else
			{
				if(cnt == 3) res++;
				cnt = 1;
			}
		}
		if(cnt == 3) res++;
		System.out.println(res);
	}
}