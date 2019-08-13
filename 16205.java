import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println((int)'A' + " " + (int)'a');
		int N = sc.nextInt();
		String str = sc.next();
		StringBuilder camel = new StringBuilder(), snake = new StringBuilder(), pascal = new StringBuilder();
		if(N == 2)
		{
			String[] s = str.split("_");
			snake.append(str.toLowerCase());
			
			for(int i = 0; i < s.length; i++)
			{
				for(int j = 0; j < s[i].length(); j++)
				{
					if(j == 0)
					{
						if(s[i].charAt(j) - 'A' >= 0 && s[i].charAt(j) - 'A' < 26)
						{
							if(i != 0) camel.append(s[i].charAt(j));
							else camel.append((char)(s[i].charAt(j)+32));
							pascal.append(s[i].charAt(j));
						}
						else
						{
							if(i != 0) camel.append((char)(s[i].charAt(j) - 32));
							else camel.append(s[i].charAt(j));
							pascal.append((char)(s[i].charAt(j) - 32));
						}
					}
					else
					{
						camel.append(s[i].charAt(j));
						pascal.append(s[i].charAt(j));
					}
				}
			}
		}
		else if(N == 3)
		{
			char[] c = str.toCharArray();
			pascal.append(str);
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] - 'A' >= 0 && c[i] - 'A' < 26)
				{
					if(i == 0) camel.append((char)(c[i]+32));
					else camel.append(c[i]);
					if(snake.toString().length() != 0) snake.append("_");
					snake.append((char)(c[i]+32));
				}
				else
				{
					camel.append(c[i]);
					snake.append(c[i]);
				}
			}
		}
		else
		{
			char[] c = str.toCharArray();
			camel.append(str);
			
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] - 'A' >= 0 && c[i] - 'A' < 26)
				{
					pascal.append(c[i]);
					if(snake.toString().length() != 0) snake.append("_");
					snake.append((char)(c[i]+32));
				}
				else
				{
					if(i == 0) pascal.append((char)(c[i]-32));
					else pascal.append(c[i]);
					snake.append(c[i]);
				}
			}
		}
		System.out.println(camel.toString());
		System.out.println(snake.toString());
		System.out.println(pascal.toString());
	}
}