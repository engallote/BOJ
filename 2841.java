import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		Stack<Integer>[] st = new Stack[N+1];
		int cnt = 0;
		
		for(int i = 0; i <= N; i++)
			st[i] = new Stack<>();
		
		for(int i = 0; i < N; i++)
		{
			int n  = sc.nextInt();
			int p = sc.nextInt();
			
			if(st[n].isEmpty())
			{
				st[n].push(p);
				cnt++;
			}
			else if(!st[n].isEmpty() && st[n].peek() < p)
			{
				st[n].push(p);
				cnt++;
			}
			else if(!st[n].isEmpty() && st[n].peek() > p)
			{
				while(!st[n].isEmpty() && st[n].peek() > p)
				{
					st[n].pop();
					cnt++;
					if(st[n].isEmpty())
					{
						st[n].push(p);
						cnt++;
						break;
					}
				}
				if(st[n].peek() != p)
				{
					st[n].push(p);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}