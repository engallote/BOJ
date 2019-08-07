import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		while(true)
		{
			String flag1 = sc.nextLine();
			if(flag1.equals("START"))
			{
				sb = new StringBuilder();
				while(true)
				{
					char[] c = sc.nextLine().toCharArray();
					if(new String(c).equals("END")) break;
					
					for(int i = 0; i < c.length; i++)
					{
						if(c[i] >= 'A' && c[i] <= 'Z')
						{
							sb.append((char)(((c[i] - 'A') + 21) % 26 + 'A'));
//							System.out.println((char)(((c[i] - 'A') + 21) % 26 + 'A'));
						}
						else sb.append(c[i]);
					}
				}
				System.out.println(sb.toString());
			}
			else break;
		}
	}
}