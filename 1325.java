import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] chk = new boolean[N+1];
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++)
        {
        	if(arr[i].size() == 0) continue;
        	Arrays.fill(chk, false);
        	q.clear();
        	q.add(i);
        	chk[i] = true;
        	int cnt = 0;
        	while(!q.isEmpty())
        	{
        		int x = q.poll();
        		cnt++;
        		for(int next : arr[x])
        		{
        			if(chk[next]) continue;
        			chk[next] = true;
        			q.add(next);
        		}
        	}
        	
        	if(max < cnt)
        	{
        		max = cnt;
        		pq.clear();
        		pq.add(i);
        	}
        	else if(max == cnt)
        		pq.add(i);
        }
        
        while(!pq.isEmpty())
        {
        	if(pq.size() == 1)
        		bw.write(pq.poll()+"");
        	else
        		bw.write(pq.poll()+" ");
        }
        bw.flush();
    }
}