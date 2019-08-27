import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.next();
			if(s.equals("#")) break;
			
			char[] ch = s.toCharArray();
			int len = ch.length-1;
			int sum = 0;
			
			for(int i = 0; i < ch.length; i++)
			{
				int a = 0, m = (int)Math.pow(8, len);
				switch(ch[i])
				{
				case '-':
					a = 0;
					sum += (a * m);
					len--;
					break;
				case '\\':
					a = 1;
					sum += (a * m);
					len--;
					break;
				case '(':
					a = 2;
					sum += (a * m);
					len--;
					break;
				case '@':
					a = 3;
					sum += (a * m);
					len--;
					break;
				case '?':
					a = 4;
					sum += (a * m);
					len--;
					break;
				case '>':
					a = 5;
					sum += (a * m);
					len--;
					break;
				case '&':
					a = 6;
					sum += (a * m);
					len--;
					break;
				case '%':
					a = 7;
					sum += (a * m);
					len--;
					break;
				case '/':
					a = -1;
					sum += (a * m);
					len--;
					break;
				}
			}
			System.out.println(sum);
		}
	}
}