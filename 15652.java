import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> arr;
	static PriorityQueue<String> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList<>();
		
		StringBuilder sb;
		
		for(int i = 1; i <= N; i++)
			solve(i, 0);
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
	private static void solve(int idx, int cnt) {
		if(cnt == M)
		{
			StringBuilder sb = new StringBuilder();
			for(int i : arr)
				sb.append(i + " ");
			if(!pq.contains(sb.toString()))
				pq.add(sb.toString());
			return;
		}
		if(idx > N) return;
		
		for(int i = idx; i <= N; i++)
		{
			arr.add(i);
			solve(i, cnt + 1);
			arr.remove(arr.size()-1);
		}
	}
}