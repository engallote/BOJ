import java.util.*;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder ans;
        while(sc.hasNext())
        {
        	ans = new StringBuilder();
        	int N = sc.nextInt();
        	long mul = 1;
        	for(int i = N; i >= 2; i--)
        	{
        		mul *= i;
        		while(mul % 10 == 0)
        			mul /= 10;
        		mul %= 10000;
        	}
        	String s = Integer.toString(N);
        	for(int i = 0; i < 5 - s.length(); i++)
        		ans.append(" ");
        	ans.append(s + " -> " + (mul%10));
        	System.out.println(ans.toString());
        }
    }
}