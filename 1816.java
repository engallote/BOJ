import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		boolean[] chk = new boolean[1000000];
		chk[0] = chk[1] = true;
		for(int i = 2; i < 1000000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j < 1000000; j += i)
				chk[j] = true;
		}
		for(int t = 0; t < tc; t++)
		{
			BigInteger bg = new BigInteger(sc.next());
			String ans = "YES";
			
			for(int i = 2; i < 1000000; i++)
				if(!chk[i])
					if(bg.mod(new BigInteger(Integer.toString(i))).compareTo(new BigInteger("0")) == 0)
					{
						ans = "NO";
						break;
					}
			System.out.println(ans);
		}
	}
}