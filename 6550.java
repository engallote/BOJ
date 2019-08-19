import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
        	char[] a = sc.next().toCharArray();
        	char[] b = sc.next().toCharArray();
            int idx = 0;
        	for(int i = 0; i < b.length; i++)
        	{
        		if(b[i] == a[idx])
        			idx++;
        		if(idx == a.length) break;
        	}
        	if(idx == a.length)
        		System.out.println("Yes");
        	else
        		System.out.println("No");
        }
    }
}