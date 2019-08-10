import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int a, b, c = 0;
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		if((1 <= a)&&(a <= 100)&&(1 <= b)&&(b <= 100)&&(1 <= c)&&(c <= 100))
		{
			if(a >= b)
			{
				if(b >= c)
					System.out.println(b);
				else if(c >= a)
					System.out.println(a);
				else
					System.out.println(c);
			}
			
			else if(b >= c)
			{
				if(c >= a)
					System.out.println(c);
				else if(a >= b)
					System.out.println(b);
				else
					System.out.println(a);
			}
			
			else if(b >= a)
			{
				if(a >= c)
					System.out.println(a);
				else if(c >= b)
					System.out.println(b);
				else
					System.out.println(c);
			}
		}
		
		else
		{
			System.out.println("1 이상 100 이하의 숫자를 입력하세요.");
		}
		
	}
}
