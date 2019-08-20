import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] sum = new long[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= N; j++)
        	{
        		int num = Integer.parseInt(st.nextToken());
        		sum[i][j] = sum[i][j-1] + num;
        	}
        }
        
        for(int i = 0; i < M; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	if(a == c && b == d)
        	{
        		System.out.println(sum[c][d] - sum[c][d-1]);
        		continue;
        	}
        	long res = 0;
        	for(int h = a; h <= c; h++)
        	{
        		res += sum[h][d] - sum[h][b-1];
        	}
        	System.out.println(res);
        }
    }
}