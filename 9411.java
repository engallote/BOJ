import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			BigDecimal a, sum = new BigDecimal("0");
			while(true)
			{
				String s = sc.next();
				if(s.equals("0"))
					break;
				
				if(s.charAt(0) == '-')
				{
					a = new BigDecimal(s.substring(1));
					a = a.multiply(new BigDecimal("-1"));
				}
				else
					a = new  BigDecimal(s);
				sum = sum.add(a);
			}
			String ans = sum.toPlainString();
			
			Queue<Character> v = new LinkedList<>();
			for(int i = ans.length() - 1; i >= 0; i--)
				v.add(ans.charAt(i));
			
			while(true)
			{
				if(v.peek() == '.')
				{
					v.poll();
					break;
				}
				else if(v.peek() == '0')
					v.poll();
				else
					break;
			}
			StringBuilder str = new StringBuilder();
			while(!v.isEmpty())
				str.append(v.poll());
			str = str.reverse();
			System.out.println(str.toString());
		}
		
	} 
}