import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int A = 0, B = 0;
        	
        	for(int i = 0; i < N; i++)
        	{
        		char a = sc.next().charAt(0);
        		char b = sc.next().charAt(0);
        		
        		if(a == b) continue;
        		else if(a == 'R')
        		{
        			if(b == 'S') A++;
        			else B++;
        		}
        		else if(a == 'P')
        		{
        			if(b == 'R') A++;
        			else B++;
        		}
        		else if(a == 'S')
        		{
        			if(b == 'P') A++;
        			else B++;
        		}
        	}
        	
        	if(A == B)
        		System.out.println("TIE");
        	else if(A > B)
        		System.out.println("Player 1");
        	else
        		System.out.println("Player 2");
        }
    }
}