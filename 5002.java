import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sub = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int cur = 0, w = 0, m = 0, cnt = 0;
		
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == '.') continue;
			if(cur == sub)
			{
				if(w > m)//���ڰ� �� ���� ��� ���ڸ� �鿩�� �Ѵ�.
				{
					int idx = i + 1;
					if(c[i] == 'M')
					{
						m++;
						cur--;
						cnt++;
					}
					else if(i + 1 < c.length && c[i+1] == 'M')
					{
						c[i+1] = '.';
						m++;
						w++;
						cnt+=2;
					}
					else break;//�� �̻� ���� ���Ѵ�.
				}
				else
				{
					if(c[i] == 'W')
					{
						w++;
						cur--;
						cnt++;
					}
					else if(i + 1 < c.length && c[i+1] == 'W')
					{
						c[i+1] = '.';
						w++;
						m++;
						cnt+=2;
					}
					else break;
				}
			}
			else if(c[i] == 'W')
			{
				w++;
				cnt++;
				cur = Math.abs(m - w);
			}
			else
			{
				m++;
				cnt++;
				cur = Math.abs(m - w);
			}
		}
		System.out.println(cnt);
	}
}