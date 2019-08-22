import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int V, E, cnt, res;
	static int[] dfsn;
	static Stack<Integer> s;
	static boolean[] finish;
	static Vector<Sort> v = new Vector<>();
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new ArrayList[V+1];
		dfsn = new int[V+1];
		finish = new boolean[V+1];
		s = new Stack<>();
		
		for(int i = 1; i <= V; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		
		cnt = 0;
		for(int i = 1; i <= V; i++)
		{
			if(finish[i]) continue;
			dfs(i);
		}
		bw.write(res+"\n");
		v.sort(null);
		for(int i = 0; i < v.size(); i++)
		{
			PriorityQueue<Integer> pq = v.get(i).pq;
			while(!pq.isEmpty())
				bw.write(pq.poll() + " ");
			if(i < v.size()-1)
				bw.write("-1\n");
			else
				bw.write("-1");
		}
        bw.flush();
    }
	private static int dfs(int idx) {
		dfsn[idx] = ++cnt;
		int now = dfsn[idx];
		s.push(idx);
		
		for(int next : arr[idx])
		{
			if(dfsn[next] == 0)
				now = Math.min(now, dfs(next));
			else if(!finish[next])
				now = Math.min(now, dfsn[next]);
		}
		if(now == dfsn[idx])
		{
			res++;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			while(true)
			{
				int tmp = s.pop();
				pq.add(tmp);
				finish[tmp] = true;
				if(tmp == idx) break;
			}
			
			v.add(new Sort(pq));
		}
		return now;
	}
}
class Sort implements Comparable<Sort>{
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	Sort(PriorityQueue<Integer> pq)
	{
		this.pq = pq;
	}
	@Override
	public int compareTo(Sort o) {
		return o.pq.peek() > this.pq.peek() ? -1 : 1;
	}
}