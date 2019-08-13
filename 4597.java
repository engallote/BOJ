import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.next();
			if(s.equals("#")) break;
			
			char[] c = s.toCharArray();
			int num = 0;
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == '1') num++;
				else if(c[i] == 'o')
				{
					if(num % 2 == 0) c[i] = '1';
					else c[i] = '0';
				}
				else if(c[i] == 'e')
				{
					if(num % 2 == 0) c[i] = '0';
					else c[i] = '1';
				}
			}
			
			System.out.println(new String(c));
		}
	}
}