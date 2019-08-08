import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int t = 0; t < N; t++)
		{
			char[] c = sc.nextLine().toCharArray();
			char[] alp = sc.nextLine().toCharArray();
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == ' ')
				{
					ans.append(" ");
					continue; 
				}
				ans.append(alp[c[i]-'A']);
			}
			
			System.out.println(ans.toString());
		}
	}
}