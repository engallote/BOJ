import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		
		a = sc.nextInt();
		if((a>0)&&(a<10))
		{
			b = sc.nextInt();
			if((b>0)&&(b<10))
			{
				int s = a;
				int div = a/b;
				int i = 0;
				System.out.print(div);
				System.out.print(".");
				
				while(i < 10)
				{
					s = s%b;
					s = s*10;
					System.out.print(s/b);
					i++;
				}
			}
			else
			{
				System.out.println("0���� ũ�� 10���� ���� ���� �Է��ϼ���.");
			}
		}
		else
		{
			System.out.println("0���� ũ�� 10���� ���� ���� �Է��ϼ���.");
		}
	}
}
