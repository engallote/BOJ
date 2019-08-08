import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		String str = "";
		while(sc.hasNext())
		{
			String tt = sc.next();
			str += tt;
		}
		char[] c = str.toCharArray();
		long tmp = 0;
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == ',')
			{
				sum += tmp;
				tmp = 0;
			}
			else 
			{
				tmp *= 10;
				tmp += (c[i] - '0');
			}
		}
		sum += tmp;
		System.out.println(sum);
	}
}