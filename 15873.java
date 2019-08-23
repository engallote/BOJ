import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		
		if(c.length == 2)
		{
			int a = c[0] - '0';
			int b = c[1] - '0';
			
			System.out.println(a+b);
		}
		else if(c.length == 3)
		{
			if(c[1] == '0')
			{
				String tmp = (c[0] - '0') + "" +(c[1] - '0');
				int a = Integer.parseInt(tmp);
				int b = c[2] - '0';
				
				System.out.println(a+b);
			}
			else if(c[2] == '0')
			{
				String tmp = (c[1] - '0') + "" + (c[2] - '0');
				int a = c[0] - '0';
				int b = Integer.parseInt(tmp);
				
				System.out.println(a+b);
			}
		}
		else
		{
			int a = Integer.parseInt((c[0] - '0')+""+(c[1] - '0'));
			int b = Integer.parseInt((c[2] - '0')+""+(c[3] - '0'));
			System.out.println(a+b);
		}
	}
}