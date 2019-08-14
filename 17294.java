import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long num = N % 10;
		N /= 10;
		if(N == 0)
		{
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
			return;
		}
		HashSet<Long> hs = new HashSet<>();
		while(N > 0)
		{
			long tmp = N % 10;
			hs.add(tmp - num);
			N /= 10;
			num = tmp;
			if(hs.size() > 1) break;
		}
		
		if(hs.size() == 1)
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
		else
			System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
	}
}