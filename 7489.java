import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = sc.nextInt();
        	long num = 1;
        	for(int i = 1; i <= N; i++)
        	{
        		num *= i;
        		while(num % 10 == 0) num /= 10;
        		num %= 2000;
        	}
        	
//        	System.out.println(num);
        	System.out.println(num%10);
        }
    }
}