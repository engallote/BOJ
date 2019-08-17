import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int D = sc.nextInt();
		
		boolean[] chk = new boolean[4000001];
		chk[0] = chk[1] = true;
		for(int i = 2; i <= 4000000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= 4000000; j+=i)
				chk[j] = true;
		}
		
		int res= 0;
		for(int i = A; i <= B; i++)
			if(!chk[i])
			{
				String s = Integer.toString(i);
				if(s.contains(D+"")) res++;		
			}
		System.out.println(res);
	}
}