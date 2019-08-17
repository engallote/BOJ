import java.util.*;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 PriorityQueue<Integer> pq = new PriorityQueue<>();
		 
		 int[] answer = new int[11];
		 
		 for(int i = 1; i <= 10; i++)
		{
			 answer[i] = ((i - 1) % 5) + 1;
//			 System.out.println(i + " : " + answer[i]);
		}
		 
		 for(int i = 0; i < N; i++)
		 {
			 int res = 0;
			 for(int j = 1; j <= 10; j++)
			 {
				 int num = sc.nextInt();
				 if(answer[j] == num) res++;
			 }
			 if(res == 10) pq.add(i+1);
		 }
		 
		 while(!pq.isEmpty())
			 System.out.println(pq.poll());
	}
}