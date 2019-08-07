import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int year = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		int year2 = sc.nextInt();
		int m2 = sc.nextInt();
		int d2 = sc.nextInt();
		
		if(year2 - year >= 0)
		{
			//만 나이
			if(m2 == m && d2 >=d) System.out.println(year2-year);
			else if(year2 > year) 
			{
				if(m2 > m || (m2 == m && d2 >= d)) System.out.println(year2-year);
				else System.out.println(year2-year-1);
			}
			else System.out.println(0);
			
			//세는 나이
			System.out.println(year2-year + 1);
			
			//연나이
			System.out.println(year2-year);
		}
	}
}