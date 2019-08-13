import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		
		int res = 0;
		for(char ch : c)
			res += (ch - 'A') + 1;
		System.out.println(res);
	}
}