import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        for(int i = 0; i < N; i++)
        {
        	String tmp = "";
        	for(int j = 0; j < M; j++)
        	{
        		if(arr[i][j] != '#') tmp += arr[i][j];
        		else
        		{
        			if(tmp.length() > 1)
                		pq.add(tmp);
        			tmp = "";
        		}
        	}
        	if(tmp.length() > 1)
        		pq.add(tmp);
        }
        
        for(int i = 0; i < M; i++)
        {
        	String tmp = "";
        	for(int j = 0; j < N; j++)
        	{
        		if(arr[j][i] != '#') tmp += arr[j][i];
        		else
        		{
        			if(tmp.length() > 1)
                		pq.add(tmp);
        			tmp = "";
        		}
        	}
        	if(tmp.length() > 1)
        		pq.add(tmp);
        }
        
        System.out.println(pq.poll());
    }
}