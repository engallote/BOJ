import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.nextLine();
			if(s.equals("*")) break;
			
			char[] c = s.toLowerCase().toCharArray();
			char start = c[0];
			int sw = 1;
			boolean flag = true;
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == ' ') sw = 2;
				else if(sw == 2)//Ã¹ ±ÛÀÚ
				{
					if(start != c[i])
					{
						flag = false;
						break;
					}
					sw = 1;
				}
			}
			System.out.println(flag ? "Y" : "N");
		}
	}
}