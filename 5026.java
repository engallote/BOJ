import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			String s = sc.next();
			if(s.contains("="))
				System.out.println("skipped");
			else
			{
				char[] c = s.toCharArray();
				int sum = 0;
				String tmp = "";
				for(int i = 0; i < c.length; i++)
				{
					if(c[i] == '+')
					{
						sum += Integer.parseInt(tmp);
						tmp = "";
					}
					else
						tmp += c[i] + "";
				}
				sum += Integer.parseInt(tmp);
				System.out.println(sum);
			}
		}
	}
}