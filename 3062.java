import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append(N);
			sb.reverse();
			
			int sum = N + Integer.parseInt(sb.toString());
			
			char[] c = Integer.toString(sum).toCharArray();
			int l = 0, r = c.length - 1;
			while(l < r)
			{
				if(c[l] == c[r])
				{
					l++;
					r--;
				}
				else break;
			}
			
			if(l >= r) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}