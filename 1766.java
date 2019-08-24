import java.util.*;

public class Main {
	static int N;
	static Vector<Integer> res = new Vector<>();
	static HashSet<Integer> hs = new HashSet<>();
	static int[] inDgree;
	static ArrayList<ArrayList<Integer>> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		inDgree = new int[N+1];	
		
		for(int i = 0; i <= N; i++)
			aly.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			aly.get(a).add(b);
			inDgree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();//번호가 작은 순서대로 출력해야 하기 때문에!!
		for(int i = 1; i <= N; i++)
			if(inDgree[i] == 0)
				pq.offer(i);
		
		while(!pq.isEmpty())
		{
			int x = pq.poll();
			System.out.print(x + " ");
			for(int j = 0; j < aly.get(x).size(); j++)
			{
				int y = aly.get(x).get(j);
				if(--inDgree[y] == 0)
					pq.offer(y);
			}
		}
	}
}