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
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
        	int num = Integer.parseInt(st.nextToken());
        	pq.add(new Pair(num, i));
        	while(pq.peek().idx <= i - L)
        		pq.poll();
        	bw.write(pq.peek().num + " ");
        }
        bw.flush();
    }
}
class Pair implements Comparable<Pair>{
	int num, idx;
	Pair(int num, int idx)
	{
		this.num = num;
		this.idx = idx;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num)
		{
			if(o.idx > this.idx) return -1;
			else return 1;
		}
		else return 1;
	}
}