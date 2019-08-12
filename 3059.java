import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int t = 0; t < N; t++)
		{
			char[] c = sc.next().toCharArray();
			boolean[] arr = new boolean[91];
			for(int i = 0; i < c.length; i++)
				arr[c[i]] = true;
			
			int res = 0;
			for(int i = 65; i <= 90; i++)
				if(!arr[i]) res += i;
			
			System.out.println(res);
		}
	}
}