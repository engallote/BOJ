import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			char[] ch = sc.nextLine().toCharArray();
			int up = 0, down = 0, num = 0, space = 0;
			
			for(int i = 0; i < ch.length; i++)
			{
				if(ch[i] - 'a' >= 0 && ch[i] - 'a' < 26)
					down++;
				else if(ch[i] - 'A' >= 0 && ch[i] - 'A' < 26)
					up++;
				else if(ch[i] - '0' >= 0 && ch[i] - '0' <= 9)
					num++;
				else
					space++;
			}
			System.out.println(down + " " + up + " " + num + " " + space);
		}
	}
}