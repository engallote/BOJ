import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solve(0);
        bw.flush();
    }
	private static void solve(int len) throws IOException {
		if(len == M)
		{
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < M; i++)
				ans.append(arr[i] + " ");
			bw.write(ans.toString()+"\n");
			return;
		}
		
		for(int i = 1; i <= N; i++)
		{
			arr[len] = i;
			solve(len + 1);
		}
	}
}