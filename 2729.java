import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int carry = 0;
			int alen = a.length - 1, blen = b.length - 1;
			StringBuilder res = new StringBuilder();
			while(alen >= 0 && blen >= 0)
			{
				if(carry == 1)
				{
					carry = 0;
					if(a[alen] == '1' && b[blen] == '1')
					{
						res.append("1");
						carry = 1;
					}
					else if(a[alen] == '0' && b[blen] == '0')
						res.append("1");
					else
					{
						res.append("0");
						carry = 1;
					}
				}
				else
				{
					if(a[alen] == '1' && b[blen] == '1')
					{
						res.append("0");
						carry = 1;
					}
					else if(a[alen] == '0' && b[blen] == '0')
						res.append("0");
					else
						res.append("1");
				}
				alen--;
				blen--;
			}
//			System.out.println(alen + " " + blen);
			if(alen >= 0)
			{
				while(alen >= 0)
				{
					if(carry == 1)
					{
						carry = 0;
						if(a[alen] == '1')
						{
							carry = 1;
							res.append("0");
						}
						else
							res.append("1");
					}
					else
						res.append(a[alen]);
					alen--;
				}
				if(carry == 1)
					res.append("1");
				carry = 0;
			}
			else if(blen >= 0)
			{
				while(blen >= 0)
				{
					if(carry == 1)
					{
						carry = 0;
						if(b[blen] == '1')
						{
							carry = 1;
							res.append("0");
						}
						else
							res.append("1");
					}
					else
						res.append(b[blen]);
					blen--;
				}
				if(carry == 1)
					res.append("1");
				carry = 0;
			}
			if(carry == 1)
				res.append("1");
			res.reverse();
			String ans = res.toString();
			if(res.toString().length() > 1)
			{
				char[] c = res.toString().toCharArray();
				int idx = -1;
				for(int i = 0; i < c.length; i++)
				{
					if(c[i] != '0') break;
					idx = i;
				}
				
				if(idx != -1)
					ans = ans.substring(idx+1);
				if(ans.length() == 0) ans = "0";
			}
			System.out.println(ans);
		}
	}
}