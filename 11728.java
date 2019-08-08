import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N], b = new int[M], arr = new int[N+M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        	a[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
        	b[i] = Integer.parseInt(st.nextToken());
        
        int l = 0, r = 0, idx = 0;
        while(true)
        {
        	if(l < N && r < M)
        	{
        		if(a[l] > b[r]) arr[idx++] = b[r++];
            	else arr[idx++] = a[l++];
        	}
        	else if(l >= N && r < M)
        		arr[idx++] = b[r++];
        	else if(r >= M && l < N) arr[idx++] = a[l++];
        	else break;
        }
        for(int i = 0; i < idx; i++)
        	bw.write(arr[i] + " ");
        bw.flush();
    }
}