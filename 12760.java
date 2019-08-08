import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<Integer>[] arr = new PriorityQueue[N+1];
		for(int i = 1; i <= N; i++)
		{
			arr[i] = new PriorityQueue<>(Collections.reverseOrder());
			for(int j = 1; j <= M; j++)
				arr[i].add(sc.nextInt());
		}
		
		Queue<Integer> idx = new LinkedList<>();
		int[] res = new int[N+1];
		int max = 0, totalMax = 0;
		for(int j = 1; j <= M; j++)
		{
			max = 0;
			idx.clear();
			
			for(int i = 1; i <= N; i++)
			{
				if(max < arr[i].peek())
				{
					max = arr[i].peek();
					idx.clear();
					idx.add(i);
				}
				else if(max == arr[i].peek()) idx.add(i);
				arr[i].poll();
			}
			
			while(!idx.isEmpty())
			{
				res[idx.peek()]++;
				totalMax = Math.max(totalMax, res[idx.poll()]);
			}
		}
		idx.clear();
		for(int i = 1; i <= N; i++)
			if(res[i] == totalMax) idx.add(i);
		
		while(!idx.isEmpty())
			System.out.print(idx.poll() + " ");
	}
}