import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		for(int i = 0; i < N; i++)
		{
			String[] str = br.readLine().split(" ");
			int[] arr = new int[N];
			for(int j = 0; j < N; j++)
				arr[j] = Integer.parseInt(str[j]);
			for(int j = 0; j < N; j++)
			{
				if(pq.contains(arr[j]))
					continue;
				else
				{
					if(pq.size() < N)
						pq.add(arr[j]);
					else
					{
						if(pq.peek() < arr[j])
						{
							pq.poll();
							pq.add(arr[j]);
						}
					}
				}
			}
		}
		System.out.println(pq.peek());
	}
}