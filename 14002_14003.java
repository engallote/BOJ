import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1], dp = new int[N+1], parent = new int[N+1], index = new int[N+1];
        int idx = 1;
        Arrays.fill(parent, -1);
        for(int i = 1; i <= N; i++)
        {
        	arr[i] = sc.nextInt();
        	if(i == 1)
        	{
        		dp[1] = arr[1];
        		index[1] = 1;
        	}
        	else
        	{
        		if(dp[idx] < arr[i])
        		{
        			dp[++idx] = arr[i];
        			parent[i] = index[idx-1];
        			index[idx] = i;
        		}
        		else
        		{
        			int l = 1, r = idx, mid;
        			while(l < r)
        			{
        				mid = (l + r) / 2;
        				if(dp[mid] >= arr[i]) r = mid;
        				else l = mid + 1;
        			}
        			dp[r] = arr[i];
        			if(r > 1) parent[i] = index[r-1];
        			index[r] = i;
        		}
        	}
        }
        
        System.out.println(idx);
        idx = index[idx];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(idx != -1)
        {
        	pq.add(arr[idx]);
        	idx = parent[idx];
        }
        while(!pq.isEmpty())
        	System.out.print(pq.poll() + " ");
	}
}