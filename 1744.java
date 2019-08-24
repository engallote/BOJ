import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> m = new PriorityQueue<>();
		int zero = 0;
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(num == 0)
			{
				zero++;
				continue;
			}
			if(num > 0)
				plus.add(num);
			else
				m.add(num);
		}
		
		long sum = 0;
		while(!plus.isEmpty())
		{
			if(plus.size() == 1)
			{
				sum += plus.poll();
				break;
			}
			int num1 = plus.poll();
			int num2 = plus.poll();
			if(num1 + num2 > num1 * num2)
				sum += (num1 + num2);
			else
				sum += (num1 * num2);
		}
		
		while(!m.isEmpty())
		{
			if(m.size() == 1)
			{
				if(zero > 0)
				{
					m.poll();
					zero--;
				}
				else
					sum += m.poll();
				break;
			}
			int num1 = m.poll();
			int num2 = m.poll();
			sum += (num1 * num2);
		}
		
		System.out.println(sum);
	}
}