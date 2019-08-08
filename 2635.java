import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		Queue<Integer> q = new LinkedList<>(), ans = new LinkedList<>();
		for(int i = N; i >= 1; i--)
		{
			q.clear();
			int num = N, pre = i;
			q.add(num);
			q.add(i);
			while(true)
			{
				num -= pre;
				if(num < 0) break;
				q.add(num);
				int tmp = num;
				num = pre;
				pre = tmp;
			}
			if(q.size() > res)
			{
				res = q.size();
				ans.clear();
				ans.addAll(q);
			}
		}
		
		System.out.println(res);
		while(!ans.isEmpty()) System.out.print(ans.poll() + " ");
	}
}