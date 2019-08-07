import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			
			HashSet<Integer> hs = new HashSet<>();
			String[] str = sc.next().split(",");
			
			for(int i = 0; i < str.length; i++)
			{
				char[] c = str[i].toCharArray();
				int a = 0, b = 0, sw = 0;
				String num = "";
				
				for(int j = 0; j < c.length; j++)
				{
					if(c[j] == '-') 
					{
						sw++;
						a = Integer.parseInt(num);
						num = "0";
					}
					else if(sw == 1) num += (c[j] - '0') + "";
					else num += (c[j] - '0') + "";
				}
				if(a == 0) a = Integer.parseInt(num);
				b = Integer.parseInt(num);
				if(a > b && b != 0) continue;
				if(b == 0) b = a;
//				System.out.println(">> " + a + " " +  b);
				for(int j = a; j <= Math.min(b, N); j++)
					hs.add(j);
			}
			
			System.out.println(hs.size());
		}
	}
}