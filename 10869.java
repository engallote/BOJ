import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		
		if((a>=1)&&(a<=10000))
		{
			b = sc.nextInt();
			if((b>=1)&&(b<=10000))
			{
				System.out.println(sum(a,b));
				System.out.println(sub(a,b));
				System.out.println(mul(a,b));
				System.out.println(div(a,b));
				System.out.println(mod(a,b));
			}
			else
			{
				System.out.println("0 이상 10000 이하의 숫자를 입력해주세요.");
			}
		}
		else
		{
			System.out.println("0 이상 10000 이하의 숫자를 입력해주세요.");
		}

	}
	public static int sum(int a, int b)
	{
		int sum = 0;
		sum = a + b;
		return sum;
	}
	public static int sub(int a, int b)
	{
		int sub = 0;
		sub = a - b;
		return sub;
	}
	public static int mul(int a, int b)
	{
		int mul = 0;
		mul = a * b;
		return mul;
	}
	public static int div(int a, int b)
	{
		int div = 0;
		div = a / b;
		return div;
	}
	public static int mod(int a, int b)
	{
		int mod = 0;
		mod = a % b;
		return mod;
	}

}
