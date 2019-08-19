import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++)
		{
			char[] c = sc.next().toCharArray();
			if(c.length == 1)
				System.out.println(c[0]);
			else
			{
				int carry = 0;
				for(int i = c.length - 1; i >= 1; i--)
				{
					if(carry == 1)
					{
						int num = (c[i] - '0') + carry;
						if(num >= 5)
							carry = 1;
						else carry = 0;
					}
					else
					{
						int num = (c[i] - '0');
						if(num >= 5)
							carry = 1;
						else carry = 0;
					}
				}
				if(carry == 1)
				{
					int num = (c[0]-'0') + 1;
					System.out.print(num);
					for(int i = 1; i < c.length; i++)
						System.out.print(0);
				}
				else
				{
					int num = (c[0]-'0');
					System.out.print(num);
					for(int i = 1; i < c.length; i++)
						System.out.print(0);
				}
				System.out.println();
			}
		}
	}
}