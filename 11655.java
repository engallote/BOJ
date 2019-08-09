import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.nextLine().toCharArray();
		
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] - 'a' >= 0 && ch[i] - 'a' < 26)
			{
				int num = ch[i] - 'a';
				if(num + 13 < 26)
					ch[i] = (char)(num + 13 + 'a');
				else
				{
					int n = (num + 13) - 26;
					ch[i] = (char)(n + 'a');
				}
			}
			else if(ch[i] - 'A' >= 0 && ch[i] - 'A' < 26)
			{
				int num = ch[i] - 'A';
				if(num + 13 < 26)
					ch[i] = (char)(num + 13 + 'A');
				else
				{
					int n = (num + 13) - 26;
					ch[i] = (char)(n + 'A');
				}
			}
			else
				continue;
		}
		for(int i = 0; i < ch.length; i++)
			System.out.print(ch[i]);
		System.out.println();
	}
}