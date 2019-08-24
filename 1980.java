import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		if(T < N && T < M)
		{
			System.out.println("0 " + T);
			return;
		}
		
		if(N > M)//N�� ���� ��
		{
			int tmp = N;
			N = M;
			M = tmp;
		}
		
		if(T % N == 0)//���� ���� ���� �������� ���
		{
			System.out.println((T/N) + " " + 0);
		}
		else//����� ���������� ���� ���
		{
			int mok = T / N;
			int max = mok;
			int k = T % N;
			while(mok > 0)
			{
				mok--;
				int tmp = T - (mok * N);
				if(tmp % M == 0)
				{
					k = 0;
					max = mok + (tmp / M);
					break;
				}
				else if(k == tmp % M)
				{
					max = Math.max(max, mok + (tmp / M));
				}
				else if(k > tmp % M)
				{
					k = tmp % M;
					max = mok + (tmp / M);
				}
			}
			
			System.out.println(max + " " + k);
		}
	}
}