import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			HashSet<String> hs = new HashSet<>();
			
			for(int i = 0; i < N; i++)
				q.add(sc.nextInt());
			hs.add(q.toString());
			boolean loop = false;
			while(true)
			{
				int start = q.poll(), size = q.size(), pre = start, zero = 0;
				for(int i = 0; i < size; i++)
				{
					q.add(Math.abs(pre - q.peek()));
					if(Math.abs(pre - q.peek()) == 0) zero++;
					pre = q.poll();
				}
				q.add(Math.abs(start - pre));
				if(Math.abs(start - pre) == 0) zero++;
				if(zero == N) break;
				if(hs.contains(q.toString()))
				{
					loop = true;
					break;
				}
				hs.add(q.toString());
			}
			
			System.out.println(loop ? "LOOP" : "ZERO");
		}
	}
}