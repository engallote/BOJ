import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			if(a == 0 && b == 0 && c == 0 && d == 0) break;
			
			if(a == b && b == c && c == d)
			{
				System.out.println(0);
				continue;
			}
			
			int na = 0, nb = 0, nc = 0, nd = 0, cnt = 0;
			
			while(true)
			{
				na = Math.abs(a - b);
				nb = Math.abs(b - c);
				nc = Math.abs(c - d);
				nd = Math.abs(a - d);
				a = na;
				b = nb;
				c = nc;
				d = nd;
				cnt++;
				if(a == b && b == c && c == d) break;
			}
			
			System.out.println(cnt);
		}
	}
}