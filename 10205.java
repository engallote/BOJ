import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();//히드라 머리
        	long res = N;
        	char[] c = sc.next().toCharArray();
        	
        	for(int i = 0; i < c.length; i++)
        	{
        		if(c[i] == 'c')
        		{
        			--res;
        			res += 2;
        		}
        		else
        			--res;
        	}
        	System.out.println("Data Set " + test_case + ":");
        	System.out.println(res);
        	if(test_case < tc)
        		System.out.println();
        }
	}
}