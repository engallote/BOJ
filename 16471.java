import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, res = 0;
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N], master = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        	arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++)
        	master[j] = Integer.parseInt(st.nextToken());
        Arrays.sort(master);
        if(master[N-1] <= arr[0])
        {
        	System.out.println("NO");
        	return;
        }
        if(arr[N-1] <= master[0])
        {
        	System.out.println("YES");
        	return;
        }
        int idx = 0, win = 0, start = 0;
        while(start < N)
        {
        	boolean flag = false;
        	for(int j = start; j < N; j++)
        		if(arr[idx] < master[j])
        		{
        			flag = true;
        			master[j] = -1;
        			start = j + 1;
        			win++;
        			break;
        		}
        	if(!flag)
        	{
        		for(int i = N - 1; i >= 0; i--)
        			if(master[i] > arr[idx])
        			{
        				master[i] = -1;
        				break;
        			}
        	}
        	if(win >= (N+1)/2) break;
        	idx++;
        }
        
        if(win >= (N+1)/2)
        	System.out.println("YES");
        else
        	System.out.println("NO");
    }
}