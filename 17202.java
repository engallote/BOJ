import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		int sw = 1;
		Queue<Integer> q = new LinkedList<>(), tmp = new LinkedList<>();
		for(int i = 0, j = 0; i < 8 && j < 8;)
		{
			if(sw == 1)
			{
				q.add(a[i]-'0');
				i++;
				sw *= -1;
			}
			else
			{
				q.add(b[j]-'0');
				j++;
				sw *= -1;
			}
		}
		q.add(b[7]-'0');
//		System.out.println(q.toString());
		while(true)
		{
			int pre = q.poll(), sum = 0;
			
			while(!q.isEmpty())
			{
				sum = pre + q.peek();
				pre = q.poll();
//				System.out.println(pre + " " + sum%10);
				tmp.add(sum%10);
			}
			
			if(tmp.size() == 2)
			{
				q.addAll(tmp);
				break;
			}
			q.addAll(tmp);
			tmp.clear();
//			System.out.println("-------");
		}
		
		while(!q.isEmpty())
			System.out.print(q.poll());
	}
}