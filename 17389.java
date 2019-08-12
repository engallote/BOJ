import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int res = 0, bonus = 0;
		
		for(int i = 1; i <= N; i++)
		{
			if(c[i-1] == 'O') 
			{
				res += i;
				res += bonus;
				bonus++;
			}
			else bonus = 0;
		}
		
		System.out.println(res);
	}
}