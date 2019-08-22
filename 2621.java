import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 0, b = 0, y = 0, g = 0;//�� ����
		int[] arr = new int[10];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < 5; i++)
		{
			char c = sc.next().charAt(0);
			int num = sc.nextInt();
			pq.add(num);
			arr[num]++;
			if(c == 'R')
				r++;
			else if(c == 'B')
				b++;
			else if(c == 'Y')
				y++;
			else
				g++;
		}
		
		boolean flag = true;//���ڰ� �����ΰ�?
		boolean four = false, thr = false, two = false;
		int start = pq.poll();
		while(!pq.isEmpty())
		{
			if(pq.peek() - start == 1)
				start = pq.poll();
			else
			{
				flag = false;
				break;
			}
		}
		if(r == 5 || b == 5 || y == 5 || g == 5)//ī�� 5�� ��� ���� ��
		{
			if(flag)
				System.out.println((start + 900));
			else
			{
				int maxNum = 0;
				for(int i = 1; i <= 9; i++)
					if(arr[i] > 0)
						maxNum = Math.max(maxNum, i);
				System.out.println((maxNum + 600));
			}
		}
		else
		{
			int maxNum = 0;
			Queue<Integer> f = new LinkedList<>();
			Queue<Integer> th = new LinkedList<>();
			PriorityQueue<Integer> tw = new PriorityQueue<>();
			for(int i = 1; i <= 9; i++)
			{
				if(arr[i] == 1)
					maxNum = Math.max(maxNum, i);
				if(arr[i] == 4)
				{
					four = true;
					f.add(i);
				}
				else if(arr[i] == 3)
				{
					thr = true;
					th.add(i);
				}
				else if(arr[i] == 2)
				{
					two = true;
					tw.add(i);
				}
			}
			if(flag)//5�� ������ ����
				System.out.println((start + 500));
			else if(four)//���� ���� 4��
				System.out.println((f.poll() + 800));
			else if(thr)//���� ���� 3��
			{
				if(two)//���� ���� 2���� ����
				{
					int res = th.poll() * 10;
					res += tw.poll() + 700;
					System.out.println(res);
				}
				else
					System.out.println((th.poll() + 400));
			}
			else if(two)//���� ���� 2��
			{
				if(tw.size() == 2)//���� ���� 2���� 2�� ���Դ�
				{
					int res = tw.poll() + (tw.poll() * 10) + 300;
					System.out.println(res);
				}
				else
					System.out.println((tw.poll() + 200));
			}
			else//���� ���ڰ� ����
				System.out.println((maxNum + 100));
		}
	}
}