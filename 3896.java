import java.util.*;

public class Main {
	static int max = 1299709;
	static boolean[] chk = new boolean[max+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chk[0] = chk[1] = true;
		
		for(int i = 2; i * i<= max; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= max; j+=i)
				chk[j] = true;
		}
		
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			if(chk[N])//�ռ������ N���� ū �Ҽ��� N���� ���� �Ҽ��� ���� ���
			{
				int st = 0, ed = 0;
				for(int j = N;; j++)
					if(!chk[j])
					{
						ed = j;
						break;
					}
				
				for(int j = N; j > 1; j--)
					if(!chk[j])
					{
						st = j;
						break;
					}
				
				System.out.println(ed - st);
			}
			else
				System.out.println(0);
		}
	}
}