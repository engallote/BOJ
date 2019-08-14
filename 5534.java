import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		int len = ch.length, res = 0;
		for(int t = 0; t < N; t++)
		{
			char[] c = sc.next().toCharArray();
			int idx = 0;
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == ch[0])
				{
					idx = 0;
					int jump = 1;
					while(jump + i < c.length)
					{
						idx = 0;
						for(int j = i; j < c.length && idx < len; j+=jump)
						{
							if(c[j] == ch[idx]) idx++;
							else break;
						}
						if(idx == len) break;
						jump++;
					}
					
					if(idx == len)
					{
//						System.out.println(new String(c) + " yes");
						res++;
					}
				}
				if(idx == len) break;
			}
		}
		
		System.out.println(res);
	}
}