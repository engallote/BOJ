import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int P = sc.nextInt();//치킨 가격
			int M = sc.nextInt();//치킨에 쓸 돈
			int F = sc.nextInt();//치킨을 시킬 때 필요한 쿠폰 수
			int C = sc.nextInt();//치킨 시키고 받는 쿠폰 수
			
			int cntS = M / P, cntD = M / P;
			int c = (C * cntS);//현찰로 내고 받는 쿠폰 수
			if(c >= F)
				cntD += (c / F);
			while(c >= F)
			{
				c -= F;
				c += C;
				cntS++;
			}
			
//			System.out.println(cntS + " " + cntD);
			System.out.println(cntS - cntD);
			
		}
	} 
}