import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		int alen = a.length - 1, blen = b.length - 1;
		for(int i = alen, j = blen; i >= 0 && j >= 0; i--, j--)
		{
			if(a[i] - '0' > b[j] - '0')
			{
//				System.out.println("a win");
				b[j] = '.';
			}
			else if(a[i] - '0' < b[j] - '0')
			{
//				System.out.println("b win");
				a[i] = '.';
			}
		}
		String num = "";
		for(int i = 0; i <= alen; i++)
			if(a[i] != '.')
				num += a[i] + "";
		if(num.length() == 0)
			System.out.println("YODA");
		else
			System.out.println(Integer.parseInt(num));
		
		num = "";
		for(int i = 0; i <= blen; i++)
			if(b[i] != '.')
				num += b[i] + "";
		if(num.length() == 0)
			System.out.println("YODA");
		else
			System.out.println(Integer.parseInt(num));
	}
}