import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	String str = sc.nextLine();
        	if(str.equals("*")) break;
        	char[] c = str.toCharArray();
        	HashSet<Character> hs = new HashSet<>();
        	for(int i = 0; i < c.length; i++)
        	{
        		if(c[i] == ' ') continue;
        		hs.add(c[i]);
        	}
        	if(hs.size() == 26) System.out.println("Y");
        	else System.out.println("N");
        }
    }
}