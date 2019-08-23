import java.util.*;

public class Main {
	static String[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.next().split("-");
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < num.length; i++)
		{
			int sum = 0;
			String n = "";
			for(int j = 0; j < num[i].length(); j++)
			{
				if(num[i].charAt(j) == '+')
				{
					sum += Integer.parseInt(n);
					n = "";
				}
				else
					n += num[i].charAt(j);
			}
			sum += Integer.parseInt(n);
			q.add(sum);
		}
		
		int res = q.poll();
		while(!q.isEmpty())
			res -= q.poll();
		
		System.out.println(res);
	}
}