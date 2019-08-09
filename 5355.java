import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		String[] str;
		sc.nextLine();
		for(int t = 0; t < tc; t++)
		{
			str = sc.nextLine().split(" ");
			double num = Double.parseDouble(str[0]);
			
			for(int i = 1; i < str.length; i++)
			{
				switch(str[i].charAt(0))
				{
				case '@' : num *= 3; break;
				case '%' : num += 5; break;
				case '#' : num -= 7; break;
				}
			}
			System.out.printf("%.2f", num);
			System.out.println();
		}
	}
}