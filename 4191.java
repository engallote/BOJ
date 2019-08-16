import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int L = sc.nextInt();
			ArrayList<Integer>[] arr = new ArrayList[N+1];
			
			for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
			for(int i = 0; i < M; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
			}
			int res = 0;
			boolean[] chk = new boolean[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i < L; i++)
			{
				int z = sc.nextInt();
				if(chk[z]) continue;
				q.offer(z);
				chk[z] = true;
				
				while(!q.isEmpty())
				{
					int x = q.poll();
					res++;
					
					for(int next : arr[x])
						if(!chk[next])
						{
							chk[next] = true;
							q.offer(next);
						}
				}
			}
			
			System.out.println(res);
		}
	}
}