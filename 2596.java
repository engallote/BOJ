import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		int count = 0;
		char[] c = sc.next().toCharArray();
		String[] str = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < c.length; i+=6)
		{
			count++;
			String s = "";
			for(int j = i; j < i + 6; j++)
				s += c[j];
			
			if(s.equals(str[0]))
				ans.append("A");
			else if(s.equals(str[1]))
				ans.append("B");
			else if(s.equals(str[2]))
				ans.append("C");
			else if(s.equals(str[3]))
				ans.append("D");
			else if(s.equals(str[4]))
				ans.append("E");
			else if(s.equals(str[5]))
				ans.append("F");
			else if(s.equals(str[6]))
				ans.append("G");
			else if(s.equals(str[7]))
				ans.append("H");
			else
			{
				int idx = -1;
				for(int j = 0; j < 8; j++)
				{
					int cnt = 0;
					for(int k = 0; k < 6; k++)
						if(str[j].charAt(k) != s.charAt(k))
							cnt++;
					if(cnt == 1)
					{
						idx = j;
						break;
					}
				}
				
				if(idx == -1)
				{
					System.out.println(count);
					return;
				}
				else
				{
					if(idx == 0)
						ans.append("A");
					else if(idx == 1)
						ans.append("B");
					else if(idx == 2)
						ans.append("C");
					else if(idx == 3)
						ans.append("D");
					else if(idx == 4)
						ans.append("E");
					else if(idx == 5)
						ans.append("F");
					else if(idx == 6)
						ans.append("G");
					else
						ans.append("H");
				}
			}
		}
		System.out.println(ans.toString());
	}
}