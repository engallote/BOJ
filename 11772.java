import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] num = new String[N];
		
		for(int i = 0; i < N; i++)
			num[i] = sc.next();
		
		long res = 0;
		for(int i = 0; i < N; i++)
		{
			int p = num[i].charAt(num[i].length()-1) - '0';
			num[i] = num[i].substring(0, num[i].length()-1);
			int n = Integer.parseInt(num[i]);
			res += (long)Math.pow(n, p);
		}
		System.out.println(res);
	}
}