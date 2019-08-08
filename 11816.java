import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		if(num.contains("0x"))
			System.out.println(Integer.parseInt(num.substring(2), 16));
		else
		{
			if(num.charAt(0) == '0')//8
				System.out.println(Integer.parseInt(num, 8));
			else
				System.out.println(num);
		}
	}
}