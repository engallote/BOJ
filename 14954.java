import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		HashSet<Long> hs = new HashSet<>();
		hs.add(Long.parseLong(new String(c)));
		boolean flag = true;
		while(true)
		{
			long num = 0;
			for(char ch : c)
				num += (long)Math.pow((ch - '0'), 2);
			if(num == 1) break;
			if(hs.contains(num))
			{
				flag = false;
				break;
			}
			hs.add(num);
			c = Long.toString(num).toCharArray();
		}
		
		System.out.println(flag ? "HAPPY" : "UNHAPPY");
	}
}