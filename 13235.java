import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int l = 0, r = c.length - 1;
		boolean flag = true;
		
		while(l <= r)
		{
			if(c[l] == c[r])
			{
				l++;
				r--;
			}
			else
			{
				flag = false;
				break;
			}
		}
		
		System.out.println(flag);
	}
}