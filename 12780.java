import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		char[] ch = sc.next().toCharArray();
		char[] n = sc.next().toCharArray();
		int len = ch.length;
		
		for(int i = 0; i < len; i++)
			if(ch[i] == n[0])
			{
				int k = 0;
				for(int j = i; j < len && k < n.length; j++)
				{
					if(ch[j] != n[k]) break;
					k++;
				}
				
				if(k == n.length)
				{
					res++;
					i += n.length - 1;
				}
			}
		
		System.out.println(res);
	}
}