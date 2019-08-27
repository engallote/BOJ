import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> plus = new Stack<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		BigInteger res = new BigInteger("0");
		int one = 0, zero = 0;
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(num == 1) one++;
			else if(num == 0) zero++;
			else if(num < 0)
				minus.add(num);
			else if(num > 0)
				plus.add(num);
		}
		plus.sort(null);
		while(!plus.isEmpty())
		{
			long tmp = plus.pop();
			if(plus.isEmpty())
				res = res.add(new BigInteger(Long.toString(tmp)));
			else
			{
				tmp *= plus.pop();
				res = res.add(new BigInteger(Long.toString(tmp)));
			}
		}
		
		while(!minus.isEmpty())
		{
			long tmp = minus.poll();
			if(minus.isEmpty())
			{
				if(zero > 0)
					zero--;
				else
					res = res.add(new BigInteger(Long.toString(tmp)));
			}
			else
			{
				tmp *= minus.poll();
				res = res.add(new BigInteger(Long.toString(tmp)));
			}
		}
		res = res.add(new BigInteger(Integer.toString(one)));
		System.out.println(res);
	}
}