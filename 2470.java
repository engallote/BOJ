import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, res = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<>();
		while(l < r)
		{
			int sum = arr[l] + arr[r];
			
			if(Math.abs(sum) <= res)
			{
				if(res > Math.abs(sum))
				{
					res = Math.abs(sum);
					q.clear();
					q.add(arr[l]);
					q.add(arr[r]);
				}
				if(res == 0) break;
			}
			if(sum > 0) r--;
			else l++;
		}
		
		while(!q.isEmpty()) System.out.print(q.poll() + " ");
	}
}