import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int P = sc.nextInt();//ġŲ ����
			int M = sc.nextInt();//ġŲ�� �� ��
			int F = sc.nextInt();//ġŲ�� ��ų �� �ʿ��� ���� ��
			int C = sc.nextInt();//ġŲ ��Ű�� �޴� ���� ��
			
			int cntS = M / P, cntD = M / P;
			int c = (C * cntS);//������ ���� �޴� ���� ��
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