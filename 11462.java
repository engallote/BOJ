import java.util.*;

public class Main {
	static int[] arr = new int[26];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	String str = sc.next();
        	if(str.equals("END")) break;
        	
        	char[] a = str.toCharArray();
        	int idx = 0;
        	for(int i = a.length - 1; i >= 0; i--)
        	{
        		if(a[i] == '0') continue;
        		idx = i;
        		break;
        	}
        	
        	StringBuilder res = new StringBuilder();
        	for(int i = 0; i < a.length; i++)
        	{
        		if(idx == i)
        			res.append(a[i]-'0'-1);
        		else res.append(a[i]);
        	}
        	System.out.println(Integer.parseInt(res.toString()));
        }
	}
}