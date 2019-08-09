import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		Stack<Integer> minus = new Stack();
		
		for(int i = 0; i < N; i++)
		{
			int n = sc.nextInt();
			if(n == 0)
			{
				minus.sort(null);
				if((!minus.isEmpty() && !plus.isEmpty()) && Math.abs(minus.peek()) > plus.peek())
					System.out.println(plus.poll());
				else if((!minus.isEmpty() && !plus.isEmpty()) && Math.abs(minus.peek()) <= plus.peek())
					System.out.println(minus.pop());
				else if(minus.isEmpty() && !plus.isEmpty())
					System.out.println(plus.poll());
				else if(!minus.isEmpty() && plus.isEmpty())
					System.out.println(minus.pop());
				else if(minus.isEmpty() && plus.isEmpty())
					System.out.println(0);
			}
			else if(n > 0)
				plus.add(n);
			else
				minus.add(n);
		}
	}
}