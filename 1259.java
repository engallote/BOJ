import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.next();
			if(s.equals("0")) break;
			StringBuilder str = new StringBuilder();
			str.append(s);
			str.reverse();
			
			if(s.equals(str.toString()))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}