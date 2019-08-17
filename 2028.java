import java.util.*;

public class Main {
	static boolean flag;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			char[] p = Integer.toString((int) Math.pow(N, 2)).toCharArray();
			char[] c = Integer.toString(N).toCharArray();
			
			int idx = c.length - 1;
			boolean flag = true;
			for(int i = p.length - 1; i >= 0; i--)
			{
				if(c[idx] != p[i])
				{
					flag = false;
					break;
				}
				idx--;
				if(idx < 0) break;
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}