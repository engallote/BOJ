import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++)
        	for(int j = i; j < N; j++)
        	{
        		if(i == j) dp[i][j] = 1;
        		else dp[i][j] = match(i, j);
        	}
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	bw.write(dp[a][b]+"\n");
        }
        bw.flush();
    }

	private static int match(int l, int r) {
		while(l <= r)
		{
			if(arr[l] == arr[r])
			{
				l++;
				r--;
			}
			else return 0;
		}
		return 1;
	}
}