import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println((int)('m'-'a'));
		int K = sc.nextInt();
		sc.nextLine();
		char[] c = sc.nextLine().toCharArray();
		for(char ch : c)
		{
			if(ch >= 'a' && ch <= 'z') 
			{
				int num = (ch-'a')-K;
				if(num < 0) num = 26 + num;
				num %= 26;
				System.out.print((char)(num+'a'));
				K++;
				if(K == 26) K = 1;
			}
			else System.out.print(ch);
		}
	}
}