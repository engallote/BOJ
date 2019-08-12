import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] primeCheck = new boolean[100001];
		ArrayList<Integer> prime = new ArrayList<>();
		int len = 0;
		for(int i = 2; i <= 100000; i++)
		{
			if(primeCheck[i]) continue;
			prime.add(i);
			for(int j = i + i; j <= 100000; j+=i) primeCheck[j] = true;
		}
		
		int T = sc.nextInt();
		len = prime.size();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>(), goal = new HashSet<>();
			for(int i = 0; i < len; i++)
			{
				if(prime.get(i) >= A && prime.get(i) <= B) goal.add(prime.get(i));
				else if(prime.get(i) > B) break;
			}
			
			if(goal.isEmpty())
			{
				System.out.println(-1);
				continue;
			}
			
			hs.add(N);
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(N);
			boolean end = false;
			int size = 0, time = 0;
			
			while(!q.isEmpty())
			{
				size = q.size();
				
				while(size > 0)
				{
					int cur = q.poll();
					if(goal.contains(cur))
					{
						end = true;
						break;
					}
					if(!hs.contains(cur / 3))
					{
						hs.add(cur / 3);
						q.offer(cur / 3);
					}
					if(!hs.contains(cur / 2))
					{
						hs.add(cur / 2);
						q.offer(cur / 2);
					}
					if(!hs.contains(cur + 1))
					{
						hs.add(cur + 1);
						q.offer(cur + 1);
					}
					if(cur > 0 && !hs.contains(cur - 1))
					{
						hs.add(cur - 1);
						q.offer(cur - 1);
					}
					size--;
				}
				if(end) break;
				time++;
			}
			
			System.out.println(end ? time : -1);
		}
	}
}