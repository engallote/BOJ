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
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N+1];
        int res = 0;
        for(int i = 0; i < N; i++)
        {
        	int num = Integer.parseInt(st.nextToken());
        	dp[num] = dp[num-1] + 1;
        	res = Math.max(res, dp[num]);
        }
        bw.write(N-res+"");
        bw.flush();
    }
}