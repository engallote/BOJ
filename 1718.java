import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] c = sc.next().toCharArray();
		int len = s.length, len2 = c.length;
		int idx = 0;
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < len; i++)
		{
			if(s[i] == ' ')
			{
				ans.append(" ");
				idx++;
				if(idx == len2)
					idx = 0;
				continue;
			}
			
			int num = s[i] - 'a';
			int sub = c[idx] - 'a' + 1;
			if(num - sub < 0)
			{
				num -= sub;
				num = 26 + num;
				ans.append((char)(num + 'a'));
			}
			else
				ans.append((char)((num-sub)+'a'));
			idx++;
			if(idx == len2)
				idx = 0;
		}
		System.out.println(ans.toString());
    }
}