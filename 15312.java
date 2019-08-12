import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		int[] num = new int['Z' + 1];
		num['A'] = 3;
		num['B'] = 2;
		num['C'] = 1;
		num['D'] = 2;
		num['E'] = 3;
		num['F'] = 3;
		num['G'] = 2;
		num['H'] = 3;
		num['I'] = 3;
		num['J'] = 2;
		num['K'] = 2;
		num['L'] = 1;
		num['M'] = 2;
		num['N'] = 2;
		num['O'] = 1;
		num['P'] = 2;
		num['Q'] = 2;
		num['R'] = 2;
		num['S'] = 1;
		num['T'] = 2;
		num['U'] = 1;
		num['V'] = 1;
		num['W'] = 1;
		num['X'] = 2;
		num['Y'] = 2;
		num['Z'] = 1;
		
		int sw = 1;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0, j = 0; i < a.length && j < b.length;)
		{
			if(sw == 1)
			{
				q.add(num[a[i]]);
				i++;
				sw *= -1;
			}
			else
			{
				q.add(num[b[j]]);
				j++;
				sw *= -1;
			}
		}
		q.add(num[b[b.length-1]]);
		int pre = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			if(size == 2) break;
			pre = q.poll();
			for(int i = 0; i < size - 1; i++)
			{
//				System.out.println(pre + " " + q.peek());
				q.add((pre + q.peek()) % 10);
				pre = q.poll();
			}
//			System.out.println("--------");
		}
		
		while(!q.isEmpty()) System.out.print(q.poll());
	}
}