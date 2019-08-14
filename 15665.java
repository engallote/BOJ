import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int N, M;
	static int[] arr, res;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		res = new int[M];
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(0);
		bw.flush();
	}
	private static void solve(int cnt) throws IOException {
		if(cnt == M)
		{
			StringBuilder sb = new StringBuilder();
			for(int i : res)
				sb.append(i + " ");
			if(!hs.contains(sb.toString()))
			{
				hs.add(sb.toString());
				bw.write(sb.toString().trim()+"\n");
			}
			return;
		}
		for(int i = 0; i < N; i++)
		{
			res[cnt] = arr[i];
			solve(cnt + 1);
		}
	}
}