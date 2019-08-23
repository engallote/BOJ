import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[10000001];
		HashSet<Long> hs = new HashSet<>();
		chk[0] = chk[1] = true;
		for(int i = 2; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= 10000000; j+=i)
				chk[j] = true;
		}
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		for(int i = 2; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			if(i * i > b) break;
			
			long n = i;
            while(i <= b / n)
            {
                if(i * n >= a)
                    hs.add(n * i);
                n *= i;
            }
		}
		
		System.out.println(hs.size());
	}
}