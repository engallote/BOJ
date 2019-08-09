import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int sum = 10;
		for(int i = 1; i < ch.length; i++)
		{
			if(ch[i-1] == ch[i])
				sum += 5;
			else
				sum += 10;
		}
		System.out.println(sum);
	}
}