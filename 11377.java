import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] chk, sum;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		chk = new int[M+1];
		sum = new int[N];
		arr = new ArrayList[N+1];
		visit = new boolean[N];
		
		Arrays.fill(chk, -1);
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			sum[i] = num;
			arr[i] = new ArrayList<>();
			for(int j = 0; j < num; j++)
				arr[i].add(Integer.parseInt(st.nextToken()));
		}
		
		int res = 0, cnt = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
				res++;
		}
		
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
			{
				res++;
				cnt++;
			}
			
			if(cnt == K) break;
		}
		System.out.println(res);
	}
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int next : arr[idx])
			if(chk[next] == -1 || dfs(chk[next]))
			{
				chk[next] = idx;
				return true;
			}
		return false;
	}
}