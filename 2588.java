import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String aNum = sc.next();
		String bNum = sc.next();		
		int res = Integer.parseInt(aNum) * Integer.parseInt(bNum);
		
		char[] a = aNum.toCharArray(), b = bNum.toCharArray();
		
		for(int i = 2; i >= 0; i--)
		{
			int num = b[i] - '0';
			num *= Integer.parseInt(new String(a));
			System.out.println(num);
		}
		System.out.println(res);
	}
}