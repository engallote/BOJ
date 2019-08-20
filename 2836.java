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
		long sum = 0, res = M;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a > b)
				pq.add(new Pair(a, b));
		}
		int start = 0, end = Integer.MAX_VALUE;
		int rs = 0, re = 0;
		HashSet<Integer> hs = new HashSet<>();
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
//			System.out.println(p.x + " " + p.y + ", " + start + " " + end);
			if(end == Integer.MAX_VALUE)
			{
				start = p.x;
				end = p.y;
			}
			else if(p.x < end)
			{
				hs.add(start);
				sum += (start - end) * 2;
				start = p.x;
				end = p.y;
			}
			else if(p.y > start)//
			{
				hs.add(start);
				sum += (start - end) * 2;
				start = p.x;
				end = p.y;
			}
			else if(p.y >= end && p.y <= start)// e < d < (s < d or d < s)
				start = Math.max(start, p.x);
			else if(p.y < end && p.x <= start) // d < e < d <= s
				end = p.y;
			else if(p.y < end && p.x > start) // d < e < s < d
			{
				start = p.x;
				end = p.y;
			}
		}
//		System.out.println(sum + " " + start + " " + end);
		if(hs.contains(start))
			res += sum;
		else
			res += sum + ((start - end) * 2);
		bw.write(res+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return 1;
		else if(o.x == this.x)
		{
			if(o.y > this.y) return -1;
			else if(o.y == this.y) return 0;
			else return 1;
		}
		else return -1;
	}
}