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
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1], all = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int task = 0;
        for(int i = 1; i <= N; i++)
        {
        	all[i] = Integer.parseInt(st.nextToken());
        	task ^= all[i];
        	arr[i] = task;
//        	System.out.println(arr[i]);
        }
        int res = 0, a = 0, b = 0, sum = 0;
        for(int i = 0; i < M; i++)
        {
        	st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
        	sum = arr[b]^arr[a-1];
//        	System.out.println(sum);
        	res ^= sum;
        }
        bw.write(res+"");
        bw.flush();
    }
}