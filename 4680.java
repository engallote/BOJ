import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static HashSet<String> hs = new HashSet<>();
	static boolean[] visit;
	static Vector<String> v = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			K = sc.nextInt();
			N = sc.nextInt();
			if(K == 0 && N == 0) break;
			PriorityQueue<Sort> pq = new PriorityQueue<>();
			arr = new int[N];
			visit = new boolean[N];
			
			for(int i = 0; i < N; i++)
				pq.add(new Sort(sc.nextInt()));
			
			for(int i = 0; i < N; i++)
				arr[i] = pq.poll().num;
			
			solve(0, 0);
			
			System.out.println("Sums of " + K + ":");
			if(v.size() == 0)
				System.out.println("NONE");
			else
				for(String s : v)
					System.out.println(s);
			v.clear();
		}
	}
	private static void solve(int idx, int sum) {
		if(sum == K)
		{
			add();
			return;
		}
		if(idx == N) return;
		
		visit[idx] = true;
		solve(idx + 1, sum + arr[idx]);
		visit[idx] = false;
		solve(idx + 1, sum);
	}
	private static void add() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			if(visit[i])
				q.add(arr[i]);
		
		String s = "";
		while(!q.isEmpty())
		{
			if(q.size() == 1)
			{
				s += q.poll();
				break;
			}
			s += q.poll() + "+";
		}
		if(!v.contains(s))
			v.addElement(s);
	}
}
class Sort implements Comparable<Sort>{
	int num;
	Sort(int num){
		this.num = num;
	}
	@Override
	public int compareTo(Sort o) {
		return o.num < this.num ? -1 : 1;
	}
}