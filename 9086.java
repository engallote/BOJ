import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			char[] ch = sc.next().toCharArray();
			System.out.println(ch[0]+""+ch[ch.length-1]);
		}
	}
}