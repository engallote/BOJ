import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long[] chk = new long[N];
		ArrayList<Pair>[] aly = new ArrayList[N];
		long res = -1;
		st = new StringTokenizer(br.readLine());
		for(int i  = 0; i < N; i++) 
		{
			arr[i] = Integer.parseInt(st.nextToken());
			aly[i] = new ArrayList<>();
		}
		Arrays.fill(chk, Long.MAX_VALUE);
		arr[N-1] = 0;
		
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long time = Long.parseLong(st.nextToken());
			
			if(arr[a] == 1 || arr[b] == 1) continue;
			aly[a].add(new Pair(b, time));
			aly[b].add(new Pair(a, time));
		}
		
		chk[0] = 0l;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		int size = 0;
		
		while(!q.isEmpty())
		{
			size = q.size();
			while(size > 0)
			{
				Pair p = q.poll();
				
				if(p.v == N - 1)
				{
					size--;
					continue;
				}
				
				
				for(Pair next : aly[p.v])
				{
					if(arr[next.v] == 0 && chk[next.v] > p.time + next.time)
					{
						chk[next.v] = p.time + next.time;
						q.offer(new Pair(next.v, p.time + next.time));
					}
				}
				size--;
			}
		}
		
		if(chk[N-1] != Long.MAX_VALUE) res = chk[N-1];
		
		bw.write(res+"");
		bw.flush();
	}
}
class Pair{
	int v;
	long time;
	Pair(int v, long time){
		this.v = v;
		this.time = time;
	}
}