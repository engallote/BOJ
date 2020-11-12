import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			hs.add(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			String str = st.nextToken();
			if(hs.contains(str)) hs.remove(str);
		}
		
		System.out.println(hs.size());
		Iterator<String> it = hs.iterator();
		while(it.hasNext())
			pq.offer(Integer.parseInt(it.next()));
		
		while(!pq.isEmpty())
			bw.write(pq.poll() + " ");
		bw.flush();
	}
}
