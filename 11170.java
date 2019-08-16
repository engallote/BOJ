import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int res = 0;
        	if(N == 0)
        	{
        		res++;
        		N += 1;
        	}
        	for(int i = N; i <= M; i++)
        	{
        		char[] c = Integer.toString(i).toCharArray();
        		for(int j = 0; j < c.length; j++)
        			if(c[j] == '0') res++;
        	}
        	System.out.println(res);
        }
	}
}