import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		String ans = sc.next();
		
		if(str1.contains(ans))
		{
			if(str2.contains(ans)) System.out.println("YES");
			else System.out.println("NO");
		}
		else System.out.println("NO");
	}
}