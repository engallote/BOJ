import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[10000];
		
		for(int i = 1; i <= N; i++)
			arr[sc.nextInt()]++;
		
		int idx = 0;
		Pair[] num = new Pair[N];
		for(int i = 0; i < 10000; i++)
			if(arr[i] > 0) 
			{
				num[idx] = new Pair(i, arr[i]);
				idx++;
			}
		
		for(int i = 0; i < idx; i++)
		{
			if(num[i].cnt == 0) continue;
			if(i + 1 < idx && num[i].num + 1 == num[i + 1].num && num[i + 1].cnt > 0)
			{
				if(i + 2 < idx && num[i+2].cnt > 0)
				{
					for(int j = 0; j < num[i].cnt; j++)
						System.out.print(num[i].num + " ");
					num[i+2].cnt -= 1;
					System.out.print(num[i+2].num + " ");
				}
				else
				{
					for(int j = 0; j < num[i+1].cnt; j++)
						System.out.print(num[i+1].num + " ");
					num[i+1].cnt = 0;
					for(int j = 0; j < num[i].cnt; j++)
						System.out.print(num[i].num + " ");
				}
			}
			else
			{
				for(int j = 0; j < num[i].cnt; j++)
					System.out.print(num[i].num + " ");
			}
		}
	}
}
class Pair{
	int num, cnt;
	Pair(int num, int cnt)
	{
		this.num = num;
		this.cnt = cnt;
	}
}