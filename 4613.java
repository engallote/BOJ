import java.util.*;

public class Main {
	static long res;
	static int alen, blen;
	static int[] a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("#")) break;
			char[] c = str.toCharArray();
			long sum = 0;
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == ' ') continue;
				sum += ((i + 1) * (c[i] - 'A' + 1));
			}
			System.out.println(sum);
		}
	}
}