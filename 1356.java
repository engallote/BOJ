import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		long sum1 = 1, sum2 = 1;
		String ans = "NO";
		for(int i = 0; i < s.length(); i++)
		{
			sum1 = 1;
			sum2 = 1;
			for(int j = 0; j <= i; j++)
				sum1 *= s.charAt(j) - '0';
			
			for(int j = i + 1; j < s.length(); j++)
				sum2 *= s.charAt(j) - '0';
//			System.out.println(sum1 + " " + sum2);
			if(sum1 == sum2)
			{
				ans = "YES";
				break;
			}
		}
		if(s.length() == 1 && s.charAt(0) == '1')
			ans = "NO";
		System.out.println(ans);
	}
}