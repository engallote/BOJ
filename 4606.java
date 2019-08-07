import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("#")) break;
			sb = new StringBuilder();
			for(char c : str.toCharArray())
			{
				if(c == ' ') sb.append("%20");
				else if(c == '!') sb.append("%21");
				else if(c == '$') sb.append("%24");
				else if(c == '%') sb.append("%25");
				else if(c == '(') sb.append("%28");
				else if(c == ')') sb .append("%29");
				else if(c == '*') sb.append("%2a");
				else sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}