import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int w = 1;
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] == 'A')
			{
				if(w == 1)
					w = 2;
				else if(w == 2)
					w = 1;
			}
			else if(ch[i] == 'B')
			{
				if(w == 2)
					w = 3;
				else if(w == 3)
					w = 2;
			}
			else
			{
				if(w == 1)
					w = 3;
				else if(w == 3)
					w = 1;
			}
		}
		System.out.println(w);
	}
}