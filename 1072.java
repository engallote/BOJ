import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println((80*100)/101);
		while(sc.hasNextLong())
		{
			long X = sc.nextLong();//total
			long Y = sc.nextLong();//win
			long Z = (Y * 100) / X;
//			System.out.println(Z + "===========");
			long l = 0, h = Integer.MAX_VALUE-1, mid = 0, ans = h;
			while(l <= h)
			{
				mid = (l + h) / 2;
				long tmp = ((Y + mid) * 100) / (X + mid);
				if(tmp != Z)
				{
//					System.out.println(tmp + " " + mid);
					h = mid - 1;
					ans = Math.min(ans, mid);
				}
				else
					l = mid + 1;
			}
			
			if(ans == h)
				System.out.println(-1);
			else
				System.out.println(ans);
		}
	}
}