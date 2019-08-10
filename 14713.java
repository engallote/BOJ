import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = "Impossible";
        int N = sc.nextInt();
        sc.nextLine();
        String[] str;
        Queue<String>[] q = new LinkedList[N];
        int[] len = new int[N];
        for(int i = 0; i < N; i++)
        {
        	q[i] = new LinkedList<>();
        	str = sc.nextLine().split(" ");
        	len[i] = str.length;
        	for(int j = 0; j < str.length; j++)
        		q[i].add(str[j]);
        }
                
        str = sc.nextLine().split(" ");
        Queue<String> ans = new LinkedList<>();
        for(int i = 0; i < str.length; i++)
        	ans.add(str[i]);
        boolean flag = true;
        while(!ans.isEmpty())
        {
        	int c = 0;
        	for(int j = 0; j < N; j++)
        	{
        		if(q[j].isEmpty()) continue;
        		if(q[j].peek().equals(ans.peek()))
        		{
        			q[j].poll();
        			ans.poll();
        			c = 1;
        			break;
        		}
        	}
        	if(c == 0)
        	{
        		flag = false;
        		break;
        	}
        }
        
        for(int i = 0; i < N; i++)
        	if(!q[i].isEmpty())
        	{
        		flag = false;
        		break;
        	}
        System.out.println(flag ? "Possible" : res);
    }
}