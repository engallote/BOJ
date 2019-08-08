import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.nextLine().toCharArray();
			int[] alp = new int[26];
			
			for(int j = 0; j < c.length; j++)
			{
				if(c[j] == ' ') continue;
				alp[c[j]-'a']++;
			}
			
			int max = 0, num = 0, idx = 0;
			for(int j = 0; j < 26; j++)
			{
				if(alp[j] > max)
				{
					max = alp[j];
					num = 1;
					idx = j;
				}
				else if(alp[j] == max) num++;
			}
			if(num != 1) System.out.println("?");
			else System.out.println((char)(idx+'a'));
		}
	}
}