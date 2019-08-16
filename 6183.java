import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] name = new String[N], word = new String[M];
		for(int i = 0; i < N; i++) name[i] = sc.next();
		for(int i = 0; i < M; i++) word[i] = sc.next();
		
		for(int i = 0; i < N; i++)
		{
			int p = 0;
			for(int j = 0; j < M; j++)
			{
				char[] c = word[j].toLowerCase().toCharArray();
				char[] ch = name[i].toLowerCase().toCharArray();
				int idx = 0;
				for(int k = 0; k < ch.length && idx < c.length; k++)
					if(ch[k] == c[idx]) idx++;
				
				if(idx >= c.length) p++;
			}
			System.out.println(p);
		}
			
	}
}