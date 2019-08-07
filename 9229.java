import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Character> hs = new HashSet<>();
		
		while(true)
		{
			String str = sc.next();
			if(str.equals("#")) break;
			Queue<String> q = new LinkedList<>();
			q.add(str);
			while(true)
			{
				str = sc.next();
				if(str.equals("#")) break;
				q.add(str);
			}
			boolean flag = true;
			char[] pre = q.poll().toCharArray(), tmp;
			while(!q.isEmpty())
			{
				tmp = q.peek().toCharArray();
				hs.clear();
				if(pre.length != tmp.length)
				{
					flag = false;
					break;
				}
				for(int i = 0; i < pre.length; i++)
				{
					hs.add(pre[i]);
					hs.add(tmp[i]);
				}
					
				if(hs.size() != pre.length + 1)
				{
					flag = false;
					break;
				}
				pre = q.poll().toCharArray();
			}
			
			System.out.println(flag ? "Correct" : "Incorrect");
		}
	}
}