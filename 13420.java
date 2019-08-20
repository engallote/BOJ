import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	String[] str = br.readLine().split(" ");
        	String res = "correct";
        	long ans = 0, a = Long.parseLong(str[0]), b = Long.parseLong(str[2]), c = Long.parseLong(str[4]);
//        	System.out.println(a+ " " + b + " " + c);
        	if(str[1].equals("+"))
        	{
        		ans = a + b;
        		if(ans != c)
        			res = "wrong answer";
        	}
        	else if(str[1].equals("*"))
        	{
        		ans = a * b;
        		if(ans != c)
        			res = "wrong answer";
        	}
        	else if(str[1].equals("-"))
        	{
        		ans = a - b;
        		if(ans != c)
        			res = "wrong answer";
        	}
        	else
        	{
        		ans = a / b;
        		if(ans != c)
        			res = "wrong answer";
        	}
        	System.out.println(res);
        }
    }
}