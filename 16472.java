import java.util.*;

public class Main {
	static int N, res = 0;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        char[] c = sc.next().toCharArray();
        int len = c.length;
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i < len; i++)
        	hs.add(c[i]);
        
        if(hs.size() <= N)
        {
        	System.out.println(len);
        	return;
        }
        for(int i = 0; i < len; i++)
        {
        	hs.clear();
        	hs.add(c[i]);
        	for(int j = i + 1; j < len; j++)
        	{
        		if(!hs.contains(c[j]))
        		{
        			if(hs.size() + 1 > N) break;
        			hs.add(c[j]);
        			res = Math.max(res, j - i + 1);
        		}
        		else
        		{
//        			System.out.println(j + " " + i);
        			res = Math.max(res, j - i + 1);
        		}
        	}
        }
        System.out.println(res);
    }
}