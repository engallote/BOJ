import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hs = new HashMap<>();
        int cnt = 1;
        while(true)
        {
        	int u = sc.nextInt();
        	int v = sc.nextInt();
        	if(u == -1 && v == -1) break;
        	else if(u == 0 && v == 0)//트리의 끝
        	{
        		Iterator<Integer> it = hs.keySet().iterator();
        		boolean root = false, any = true;
        		int k = 0;
        		while(it.hasNext())
        		{
        			k++;
        			int key = it.next();
        			int value = hs.get(key);
//        			System.out.println(key + " " + value);
        			if(value == 0 && !root)
        				root = true;
        			else if(value == 0 && root)
        			{
        				root = false;
        				break;
        			}
        			else if(value >= 2)
        			{
        				any = false;
//        				break;
        			}
        		}
        		if(k == 0)//비어있는 트리 
        			System.out.println("Case " + cnt + " is a tree.");
        		else if(root && any)
        			System.out.println("Case " + cnt + " is a tree.");
        		else
        			System.out.println("Case " + cnt + " is not a tree.");
        		hs.clear();
            	cnt++;
        		continue;
        	}
        	else
        	{
        		if(!hs.containsKey(u))
        			hs.put(u, 0);
        		if(hs.containsKey(v))
        		{
        			int value = hs.get(v) + 1;
        			hs.remove(v);
        			hs.put(v, value);
        		}
        		else
        			hs.put(v, 1);
        	}
        }
	}
}