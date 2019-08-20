import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	int T = sc.nextInt();
        	
        	int[] arr = new int[N];
        	boolean[] chk = new boolean[N];
        	HashSet<Integer> hs = new HashSet<>();
        	int cnt = 0, idx = 0;
        	int count = 0, number = 0;
        	while(true)
        	{
        		hs.clear();
        		cnt = 0;
            	while(cnt < T)
            	{
            		if(chk[idx])
            		{
            			idx++;
            			if(idx == N) idx = 0;
            			continue;
            		}
            		arr[idx]++;
            		cnt++;
            		if(cnt >= T)
            		{
            			chk[idx] = true;
            		}
            		idx++;
            		if(idx == N) idx = 0;
            	}
            	
            	count = 0;
            	number = 0;
            	for(int i = 0; i < N; i++)
            		if(!chk[i])
            		{
            			count++;
            			number = arr[i];
            			hs.add(number);
            		}
            	if(hs.size() == 1) break;
        	}
        	
        	System.out.println(count + " " + number);
        }
    }
}