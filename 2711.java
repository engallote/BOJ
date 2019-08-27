import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			
			ch[N-1] = ' ';
			
			for(int i = 0; i < ch.length; i++)
				if(ch[i] != ' ')
					System.out.print(ch[i]);
			System.out.println();
		}
	}
}