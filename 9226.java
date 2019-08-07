import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		
		while(true)
		{
			String str = sc.next();
			if(str.equals("#")) break;
			
			char[] c = str.toCharArray();
			int idx = 0;
			Queue<Character> q = new LinkedList<>();
			
			while(idx < c.length)
			{
				if(hs.contains(c[idx])) break;
				q.add(c[idx]);
				idx++;
			}
			
			if(q.size() == c.length)//단어에 모음이 없다
			{
				while(!q.isEmpty()) System.out.print(q.poll());
				System.out.println("ay");
			}
			else
			{
				for(int i = idx; i < c.length; i++)
					System.out.print(c[i]);
				while(!q.isEmpty()) System.out.print(q.poll());
				System.out.println("ay");
			}
		}
	}
}