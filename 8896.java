import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0 ; t < tc; t++)
        {
        	int N = sc.nextInt();
        	String[] str = new String[N];
        	boolean[] chk = new boolean[N];
        	int len = 0;
        	for(int i = 0; i < N; i++)
        		str[i] = sc.next();
        	len = str[0].length();
        	ArrayList<Integer>[] arr = new ArrayList[3];
        	arr[0] = new ArrayList<>();
        	arr[1] = new ArrayList<>();
        	arr[2] = new ArrayList<>();
        	int winner = 0;
        	for(int i = 0; i < len; i++)
        	{
        		arr[0].clear();
        		arr[1].clear();
        		arr[2].clear();
        		int game = 0;
        		for(int j = 0; j < N; j++)
        			if(!chk[j])
        			{
        				game++;
        				if(str[j].charAt(i) == 'R') arr[0].add(j);
        				else if(str[j].charAt(i) == 'S') arr[1].add(j);
        				else if(str[j].charAt(i) == 'P') arr[2].add(j);
        			}
        		if(game == 1)
        		{
        			for(int j = 0; j < N; j++)
        				if(!chk[j])
        				{
        					winner = j+1;
        					break;
        				}
        			break;
        		}
        		else if(game == 0) break;
        		if(arr[0].size() > 0 && arr[1].size() > 0 && arr[2].size() > 0) continue;
        		else if(arr[0].size() > 0)//주먹 기준
    			{
    				if(arr[1].size() > 0)//가위
    				{
    					for(int k : arr[1])
    						chk[k] = true;
    				}
    				else if(arr[2].size() > 0)//보
    				{
    					for(int k : arr[0])
    						chk[k] = true;
    				}
    			}
        		else if(arr[1].size() > 0)//가위 기준
    			{
    				if(arr[0].size() > 0)//바위
    				{
    					for(int k : arr[1])
    						chk[k] = true;
    				}
    				else if(arr[2].size() > 0)//보
    				{
    					for(int k : arr[2])
    						chk[k] = true;
    				}
    			}
        		else if(arr[2].size() > 0)//보 기준
    			{
    				if(arr[0].size() > 0)//바위
    				{
    					for(int k : arr[0])
    						chk[k] = true;
    				}
    				else if(arr[1].size() > 0)//가위
    				{
    					for(int k : arr[2])
    						chk[k] = true;
    				}
    			}
        	}
        	if(winner != 0)
        		System.out.println(winner);
        	else
        	{
        		int cnt = 0;
            	for(int i = 0; i < N; i++)
            		if(!chk[i])
            		{
            			cnt++;
            			winner = i + 1;
            		}
            	if(cnt == 1)
            		System.out.println(winner);
            	else
            		System.out.println(0);
        	}
        }
    }
}