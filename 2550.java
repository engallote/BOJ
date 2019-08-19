import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] button = new int[N+1], arr = new int[N+1], dp = new int[N+1];
		int[] parent = new int[N+1], index = new int[N+1];
		int idx = 1;
		for(int i = 1; i <= N; i++)
			button[i] = sc.nextInt();
		
		for(int i = 1; i <= N; i++)
			arr[sc.nextInt()] = i;
		
		Arrays.fill(parent, -1);
		dp[1] = arr[button[1]];
		index[1] = 1;
		for(int i = 2; i <= N; i++)
		{
//			System.out.println(">> " + arr[button[i]]);
			if(dp[idx] < arr[button[i]])
			{
				dp[++idx] = arr[button[i]];
				parent[i] = index[idx-1];
				index[idx] = i;
			}
			else
			{
				int l = 1, r = idx, mid;
				while(l < r)
				{
					mid = (l + r) / 2;
					if(dp[mid] >= arr[button[i]]) r = mid;
					else l = mid + 1;
				}
				dp[r] = arr[button[i]];
				if(r > 1)
					parent[i] = index[r-1];
				index[r] = i;
			}
		}
		System.out.println(idx);
		int ch = index[idx];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(ch != -1)
		{
			pq.add(button[ch]);
			ch = parent[ch];
		}
		while(!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}