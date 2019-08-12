import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] chk = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int time = 0;
		boolean flag = false;
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				int x = q.poll();
				if(x == 0)
				{
					flag = true;
					break;
				}
				if(!chk[x-1])
				{
					chk[x-1] = true;
					q.add(x-1);
				}
				if(x > a && !chk[x - a - 1])
				{
					chk[x-a-1] = true;
					q.add(x-a-1);
				}
				if(x > b && !chk[x-b-1])
				{
					chk[x-b-1] = true;
					q.add(x-b-1);
				}
			}
			if(flag) break;
			time++;
		}
		
		System.out.println(time);
	}
}