import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	Queue<String> q = new LinkedList<>();
        	for(int i = 0; i < N; i++)
        		q.add(sc.next());
        	String[] arr = new String[N];
        	int l = 0, r = N - 1;
        	
        	while(l <= r)
        	{
        		if(q.size() == 1)
        		{
        			arr[l] = q.poll();
        			break;
        		}
        		else
        		{
        			arr[l] = q.poll();
        			arr[r] = q.poll();
        			l++;
        			r--;
        		}
        	}
        	System.out.println("SET " + tc);
        	for(int i = 0; i < N; i++)
        		System.out.println(arr[i]);
        	tc++;
        }
    }
}