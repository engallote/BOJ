import java.util.*;

public class Main {
	static int N, K;
	static char[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new char[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.next().charAt(0);
		HashSet<String> hs = new HashSet<>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(new String(arr), 0));
		hs.add(new String(arr));
		Arrays.sort(arr);
		String res = new String(arr);
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.num.equals(res))
				{
					System.out.println(p.cnt);
					return;
				}
				StringBuilder sb;
				
				for(int i = 0; i <= N - K; i++)
				{
					String start = p.num.substring(0, i);
					String end = p.num.substring(i+K);
					String mid = "";
					sb = new StringBuilder();
					sb.append(p.num.substring(i, i + K));
					sb.reverse();
					mid = sb.toString();
					sb = new StringBuilder();
					sb.append(start);
					sb.append(mid);
					sb.append(end);
					
					if(!hs.contains(sb.toString()))
					{
						hs.add(sb.toString());
						q.offer(new Pair(sb.toString(), p.cnt + 1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
class Pair{
	int cnt;
	String num;
	Pair(String num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}