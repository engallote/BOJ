import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        
        for(int i = 1; i < str.length; i++)
        {
        	char[] c = str[i].toCharArray();
        	String name = "";
        	StringBuilder other = new StringBuilder();
        	for(int j = 0; j < c.length - 1; j++)
        	{
        		if(c[j] == ',' || c[j] == ';') continue;
        		else if((c[j] >= 'a' && c[j] <= 'z') || (c[j] >= 'A' && c[j] <= 'Z'))
        			name += "" + c[j];
        		else
        			other.append(""+c[j]);
        	}
        	System.out.print(str[0]);
        	String t = other.toString();
        	for(int j = t.length() - 1; j >= 0; j--)
        	{
        		if(t.charAt(j) == '[')
        			System.out.print("]");
        		else if(t.charAt(j) == ']')
        			System.out.print("[");
        		else if(t.charAt(j) == '(')
        			System.out.print(")");
        		else if(t.charAt(j) == ')')
        			System.out.print("(");
        		else
        			System.out.print(t.charAt(j));
        	}
        	
        	System.out.println(" " + name + ";");
        }
    }
}