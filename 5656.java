import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true)
        {
        	int a = sc.nextInt();
        	String op = sc.next();
        	int b = sc.nextInt();
        	if(op.equals("E")) break;
        	System.out.printf("Case %d: ", tc++);
        	switch(op){
        	case "<": System.out.println((a<b)); break;
        	case ">": System.out.println((a>b)); break;
        	case "<=": System.out.println((a<=b)); break;
        	case ">=": System.out.println((a>=b)); break;
        	case "==": System.out.println((a==b)); break;
        	case "!=": System.out.println((a!=b)); break;
        	}
        }
	}
}