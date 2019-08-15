import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int len = c.length;
		int jump = 1, time = 0;
		for(int i = 0; i < len; i++)
		{
			if(c[i] == 'N')
			{
				jump++;
				continue;
			}
			
			for(int j = i; j < len; j+=jump)
			{
				if(c[j] == 'N') c[j] = 'Y';
				else c[j] = 'N';
			}
			jump++;
			time++;
		}
		
		for(char ch : c)
			if(ch == 'Y')
			{
				System.out.println(-1);
				return;
			}
		
		System.out.println(time);
	}
}