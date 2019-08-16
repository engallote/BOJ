import java.util.*;

public class Main {
	static int N, K;
	static boolean flag = false;
	static int[][] arr;
	static int[] k = new int[20], m = new int[20];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();//�¼�
        arr = new int[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++)
        	for(int j = 1; j <= N; j++)
        		arr[i][j] = sc.nextInt();
        
        for(int i = 0; i < 20; i++)
        	k[i] = sc.nextInt();
        for(int i = 0; i < 20; i++)
        	m[i] = sc.nextInt();
        
        solve(0, 0, 0, 'g', 'k', 0, 0, 0, 0, 0);
        System.out.println(flag ? 1 : 0);
	}
	private static void solve(int gidx, int kidx, int midx, char who1, char who2, int win, int kw, int mw, int pre, int chk) {
		if(flag) return;
		if(win >= K)
		{
			flag = true;
			return;
		}
		if(gidx >= 20 || kw >= K || mw >= K) return;
//		System.out.println(who1 + " " + who2);
//		System.out.println(gidx + " " + kidx + " " + midx);
		if(who1 == 'g' || who2 == 'g')//���� ����
		{
			int num = 0;
			char w = '.';
			if(who1 == 'k' || who2 == 'k')
			{
				if(kidx >= 20) return;
				num = k[kidx];
				w = 'k';
			}
			else if(who1 == 'm' || who2 == 'm')
			{
				if(midx >= 20) return;
				num = m[midx];
				w = 'm';
			}
			
			for(int i = 1; i <= N; i++)
				if((chk&(1<<i)) == 0)
				{
					if(arr[i][num] == 2)//������ �̰��
					{
						if(w == 'k') solve(gidx + 1, kidx + 1, midx, 'g', 'm', win + 1, kw, mw, i, chk|(1<<i));//������ ��ȣ
						else solve(gidx + 1, kidx, midx + 1, 'g', 'k', win + 1, kw, mw, i, chk|(1<<i));//������ ����
					}
					else//������ ���� ���ų� ��밡 �̰��
					{
						if(w == 'k') solve(gidx + 1, kidx + 1, midx, w, 'm', win, kw + 1, mw, i, chk|(1<<i));//����� ��ȣ
						else solve(gidx + 1, kidx, midx + 1, w, 'k', win, kw, mw + 1, i, chk|(1<<i));//��ȣ�� ����
					}
				}
		}
		else//����� ��ȣ�� ���
		{
			if(kidx >= 20 || midx >= 20) return;
			if(arr[k[kidx]][m[midx]] == 2)//���� �̰��
				solve(gidx, kidx + 1, midx + 1, 'k', 'g', win, kw + 1, mw, pre, chk);
			else//����� ��ȣ�� ���ų� ��ȣ�� �̰��
				solve(gidx, kidx + 1, midx + 1, 'm', 'g', win, kw, mw + 1, pre, chk);
		}
	}
}