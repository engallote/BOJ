import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        char op = '+';
        while(true)
        {
        	String str = sc.next();
        	if(str.equals("=")) break;
        	
        	if(str.equals("+")) op = '+';
        	else if(str.equals("-")) op = '-';
        	else if(str.equals("*")) op = '*';
        	else if(str.equals("/")) op = '/';
        	else
        	{
        		switch(op){
        		case '+': res += Integer.parseInt(str); break;
        		case '-': res -= Integer.parseInt(str); break;
        		case '*': res *= Integer.parseInt(str); break;
        		case '/': res /= Integer.parseInt(str); break;
        		}
        	}
        }
        System.out.println(res);
	}
}