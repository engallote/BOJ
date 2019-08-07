import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		int num = 1;
		for(int i = 0; i < N; i++)
		{
			char a = sc.next().charAt(0);
			if(a == 'A')
			{
				char s = sc.next().charAt(0);
				if(s == 'L') dq.offerFirst(num);
				else dq.offerLast(num);
				num++;
			}
			else
			{
				char s = sc.next().charAt(0);
				int k = sc.nextInt();
				
				if(s == 'L')
					while(k > 0)
					{
						dq.pollFirst();
						k--;
					}
				else
					while(k > 0)
					{
						dq.pollLast();
						k--;
					}
			}
		}
		
		while(!dq.isEmpty())
			System.out.println(dq.poll());
	}
}