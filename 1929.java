import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] chk = new boolean[M+1];
		
		chk[0] = chk[1] = true;
		for(int i = 2; i <= M; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= M; j+=i)
				chk[j] = true;
		}
		
		for(int i = N; i <= M; i++)
			if(!chk[i])
				System.out.println(i);
	}
}