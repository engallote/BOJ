import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] par, chk, indgree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		chk = new int[N + 1];
		par = new int[N + 1];
		indgree = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Pair(b, c));
			++indgree[b];
		}
		
		bfs();
		
		bw.write(chk[1]+"\n");
		int idx = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		while(par[idx] != 1) {
			stack.push(par[idx]);
			idx = par[idx];
		}
		stack.push(1);
		while(!stack.isEmpty()) bw.write(stack.pop() + " ");
		bw.flush();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		while(indgree[1] > 0) {
			int x = q.poll();
			
			for(Pair next : arr[x]) {
				--indgree[next.v];
				if(chk[next.v] < chk[x] + next.w) {
					chk[next.v] = chk[x] + next.w;
					par[next.v] = x;
				}
				if(indgree[next.v] == 0) q.offer(next.v);
			}
		}
	}
}
class Pair{
	int v, w;
	Pair(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
