import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			String s = Integer.toBinaryString(N);
			StringBuilder str = new StringBuilder();
			str.append(s);
			str.reverse();
			s = str.toString();
			for(int i = 0; i < s.length(); i++)
				if(s.charAt(i) == '1')
					System.out.print(i + " ");
		}
	}
}