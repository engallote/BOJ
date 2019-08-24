import java.util.*;

public class Main {
	static int[] arr, min, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		int len = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))+1);
		min = new int[len];
		max = new int[len];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.fill(max, -1);
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		makeMin(1, 0, N-1);
		makeMax(1, 0, N-1);
		
//		for(int i = 1; i < len; i++)
//			System.out.println(min[i] + " " + max[i]);
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			System.out.println(findMin(1, 0, N-1, a, b) + " " + findMax(1, 0, N-1, a, b));
		}
	}
	private static int findMax(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return -1;
		if(left <= start && end <= right)
			return max[node];
		return Math.max(findMax(node * 2, start, (start + end) / 2, left, right),
				findMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
	private static int findMin(int node, int start, int end, int left, int right) {
		 if(left > end || right < start) return Integer.MAX_VALUE-1;
		 if(left <= start && end <= right)
			 return min[node];
		 return Math.min(findMin(node * 2 , start, (start + end) / 2, left, right),
				 findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
	private static int makeMax(int node, int start, int end) {
		if(start == end)
			return max[node] = arr[start];
		else
			return max[node] = Math.max(makeMax(node * 2, start, (start + end) / 2),
					makeMax(node * 2 + 1, (start + end) / 2 + 1, end));
	}
	private static int makeMin(int node, int start, int end) {
		if(start == end)
			return min[node] = arr[start];
		else
			return min[node] = Math.min(makeMin(node * 2, start, (start + end) / 2),
					makeMin(node * 2 + 1, (start + end) / 2 + 1, end));
	}
}