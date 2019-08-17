import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.nextLine();
			if(s.equals("#")) break;
			char[] c = s.toLowerCase().toCharArray();
			int sum = 0;
			for(int i = 0; i < c.length; i++)
				if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u')
					sum++;
			
			System.out.println(sum);
		}
	}
}