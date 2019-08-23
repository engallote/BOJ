import java.util.*;

public class Main {
	static int N, len;
	static int[] arr;
	static long[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		len = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		tree = new long[len];
		
		for(int i = 0; i < M; i++)
		{
			int s = sc.nextInt();			
			if(s == 1)
			{
				int idx = sc.nextInt()-1;
				int num = sc.nextInt();
				
				int dif = num - arr[idx];
				arr[idx] = num;
				
				update(1, 0, N-1, idx, dif);
			}
			else
			{
				int left = sc.nextInt()-1;
				int right = sc.nextInt()-1;
				if(left > right)
				{
					int tmp = left;
					left = right;
					right = tmp;
				}
				System.out.println(sum(1, 0, N-1, left, right));
			}
		}
	}
	private static long sum(int node, int start, int end, int left, int right) {
		if(right < start || end < left) return 0;
		if(left <= start && end <= right) return tree[node];
		return sum(node * 2, start, (start + end) / 2, left, right)
				+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}
	private static void update(int node, int start, int end, int idx, int dif) {
		if(idx < start || end < idx) return;
		 tree[node] += dif;
		 
		if(start != end)
		{
			update(node * 2, start, (start + end) / 2,idx, dif);
			update(node * 2 + 1, (start + end) / 2 + 1, end, idx, dif);
		}	
	}
}