import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = sc.nextInt();
        	Queue<String> q = new LinkedList<>();
        	for(int i = 1; i < 12; i++)
        		for(int j = i + 1; j <= 12; j++)
        			if(i + j == N)
        				q.add(i + " " + j);
        	System.out.print("Pairs for " + N + ": ");
        	if(q.isEmpty()) System.out.println();
        	while(!q.isEmpty())
        	{
        		if(q.size() == 1)
        			System.out.println(q.poll());
        		else
        			System.out.print(q.poll() + ", ");
        	}
        }
    }
}