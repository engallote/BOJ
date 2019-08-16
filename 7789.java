import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[10000001];
		chk[0] = chk[1] = true;
		
		for(int i = 2; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= 10000000; j+=i)
				chk[j] = true;
		}
		
		int num = sc.nextInt();
		int N = sc.nextInt();
		
		if(!chk[num])
		{
			String tmp = N + "" + num;
			int newNum = Integer.parseInt(tmp);
			
			if(chk[newNum]) System.out.println("No");
			else
				System.out.println("Yes");
		}
		else
			System.out.println("No");
	}
}