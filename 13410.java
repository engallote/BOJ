import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder str;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 1; i <= K; i++)
		{
			int num = i * N;
			str = new StringBuilder();
			str.append(num);
			str.reverse();
			
			pq.add(Integer.parseInt(str.toString()));
		}
		System.out.println(pq.poll());
	}
}