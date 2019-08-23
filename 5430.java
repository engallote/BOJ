import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			char[] order = sc.next().toCharArray();
			int N = sc.nextInt();
			String s = sc.next();
			s = s.replaceAll(",", " ");
			s = s.replace("[", "");
			s = s.replace("]", "");
			String[] str = s.split(" ");
			Deque<Integer> dq = new LinkedList<>();
			
			for(int i = 0; i < N; i++)
				dq.add(Integer.parseInt(str[i]));
			
			boolean flag = false, rev = false;
			for(int i = 0; i < order.length; i++)
			{
				if(flag) break;
				if(order[i] == 'R')
				{
					rev = !rev;
				}
				else
				{
					if(dq.isEmpty())
						flag = true;
					else if(rev)
						dq.pollLast();
					else
						dq.pollFirst();
				}
			}
			if(flag)
				System.out.println("error");
			else
			{
				if(rev)
				{
					System.out.print("[");
					while(!dq.isEmpty())
					{
						if(dq.size()==1)
							System.out.print(dq.pollLast());
						else
							System.out.print(dq.pollLast()+",");
					}
					System.out.println("]");
				}
				else
				{
					System.out.print("[");
					while(!dq.isEmpty())
					{
						if(dq.size()==1)
							System.out.print(dq.pollFirst());
						else
							System.out.print(dq.pollFirst()+",");
					}
					System.out.println("]");
				}
			}
		}
	}
}