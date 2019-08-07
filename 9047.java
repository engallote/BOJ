import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			PriorityQueue<Integer> min = new PriorityQueue<>(), max = new PriorityQueue<>(Collections.reverseOrder());
			int res = 0;
			while(N != 6174)
			{
				while(N > 0)
				{
					int num = N % 10;
					min.add(num);
					max.add(num);
					N /= 10;
				}
				if(min.size() < 4) min.add(0);
				if(max.size() < 4) max.add(0);
				N = 0;
				while(!min.isEmpty())
				{
					int num = max.poll() - min.poll();
					N *= 10;
					N += num;
				}
				res++;
			}
			
			System.out.println(res);
		}
	}
}