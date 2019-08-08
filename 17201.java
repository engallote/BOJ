import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int len = N * 2, pre = 0;
		boolean flag = true;
		for(int i = 0; i < len; i++)
		{
			if(pre != c[i] - '0')
				pre = c[i] - '0';
			else
			{
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "Yes" : "No");
	}
}