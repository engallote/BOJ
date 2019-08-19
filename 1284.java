import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			int res = 2;
			char[] c = Integer.toString(N).toCharArray();
			int mid = c.length - 1;
			
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == '0') res += 4;
				else if(c[i] == '1') res += 2;
				else res += 3;
			}
			res += mid;
			System.out.println(res);
		}
	}
}