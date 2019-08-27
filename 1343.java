import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String ans = "";
		Vector<Integer> v = new Vector<>();
		int cnt = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '.')
			{
				v.add(cnt);
				v.add(-1);
				cnt = 0;
			}
			else
				cnt++;
		}
		if(cnt != 0)
			v.addElement(cnt);
		
		for(int i = 0; i < v.size(); i++)
		{
			if(v.get(i) == -1)
			{
				ans += ".";
				continue;
			}
			if(v.get(i) % 2 != 0)
			{
				System.out.println(-1);
				return;
			}
			int num = v.get(i);
			int tmp = num / 4;
			num %= 4;
			
			while(tmp > 0)
			{
				ans += "AAAA";
				tmp--;
			}
			while(num > 0)
			{
				ans += "B";
				num--;
			}
		}
		
		System.out.println(ans);
	}
}