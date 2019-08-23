import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		
		for(int i = 0; i < N; i++)
			str[i] = sc.next();
		
		int Q = sc.nextInt();
		
		for(int i = 0; i < Q; i++)
		{
			String s = sc.next();
			boolean flag = false;
			for(int j = 0; j < N; j++)
				if(s.contains(str[j]))
				{
					flag = true;
					break;
				}
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}