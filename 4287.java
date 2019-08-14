import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.next();
			if(s.equals("#")) break;
			
			char[] a = s.toCharArray();
			char[] b = sc.next().toCharArray();
			char[] c = sc.next().toCharArray();
			char[] d = new char[c.length];
			int len = a.length;
			for(int i = 0; i < len; i++)
			{
				int num = b[i] - a[i];
				num = ((c[i] - 'a') + num);
				if(num < 0) num = 26 + num;
				num %= 26;
				char ch = (char)(num+'a');
				d[i] = ch;
			}
			
			System.out.println(new String(a) + " " + new String(b) + " " + new String(c) + " " + new String(d));
		}
	}
}