import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static long[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		tree = new long[(int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)];
		Arrays.fill(tree, Long.MAX_VALUE-1);
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		make(1, 0, N-1);
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			System.out.println(findMin(1, 0, N - 1, a, b));
		}
	}
	private static long findMin(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return Long.MAX_VALUE-1;
		if(left <= start && end <= right)
			return tree[node];
		return Math.min(findMin(node * 2, start, (start + end)/2, left, right),
				findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
	private static long make(int node, int start, int end) {
		if(start == end)
			return tree[node] = arr[start];
		else
		{
			return tree[node] = Math.min(make(node * 2, start, (start + end) / 2), 
					make(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}
}