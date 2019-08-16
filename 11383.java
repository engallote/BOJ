import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] str = new String[N];
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			str[i] = "";
			for(char ch : c) str[i] += ch + "" + ch;
		}
		boolean flag = true;
		for(int i = 0; i < N; i++)
		{
			String s = sc.next();
			if(!str[i].equals(s)) flag = false;
		}
		System.out.println(flag ? "Eyfa" : "Not Eyfa");
	}
}