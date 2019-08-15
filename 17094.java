import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int t = 0, y = 0;
		for(char ch : c)
		{
			if(ch == '2') t++;
			else y++;
		}
		
		if(t > y) System.out.println(2);
		else if(t == y) System.out.println("yee");
		else System.out.println("e");
	}
}