import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = 0, y = 0, cnt = 1, sw = 1, who = 1;
		
		while(true)
		{
			for(int i = 0; i < 2; i++)
			{
				if(who == 1)
				{
					for(int j = 0; j < cnt; j++)
					{
						x += sw;
						N--;
						if(N == 0) break;
					}
				}
				else 
				{
					for(int j = 0; j < cnt; j++)
					{
						y += sw;
						N--;
						if(N == 0) break;
					}
				}
				who *= -1;
				if(N == 0) break;
			}
			sw *= -1;
			cnt++;
			if(N == 0) break;
		}
		
		System.out.println(y + " " + x);
	}
}