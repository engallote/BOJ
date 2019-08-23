import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 0;
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int l = 0, h = 30000, mid, res = h;
		String ans = "";
		Vector<Integer> v = new Vector<>();
		while(l <= h)
		{
			mid = (l + h) / 2;
			int sum = 0, cnt = 1;
			min = 0;
			for(int i = 0; i < N; i++)
			{
				if(sum + arr[i] <= mid)
				{
					sum += arr[i];
				}
				else
				{
					cnt++;
					sum = arr[i];
				}
				min = Math.max(min, sum);
			}
			
			if(cnt <= M)
			{
				if(res > min)
					res = min;
				h = mid - 1;
			}
			else if(cnt > M)
				l = mid + 1;
		}
		int sum = 0, cnt = 0;
		
		for(int i = 0; i < N; i++)
		{
			if(sum + arr[i] <= res)
			{
				sum += arr[i];
				cnt++;
			}
			else
			{
				v.add(cnt);
				cnt = 1;
				sum = arr[i];
			}		
		}
		v.addElement(cnt);
		
		System.out.println(res);
		if(v.size() == M)
			for(int i : v)
				System.out.println(i + " ");
		else
		{
			int count = M - v.size();
			for(int i = 0; i < v.size(); i++)
			{
				if(v.get(i) == 1)
					System.out.print(1 + " ");
				else if(count > 0)
				{
					System.out.print(1 + " ");
					int tmp = v.get(i)-1;
					v.remove(i);
					v.insertElementAt(tmp, i);
					--i;
					count--;
				}
				else
					System.out.print(v.get(i) + " ");
			}
		}
		
	}
}