import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        {
        	char[] c = sc.next().toCharArray();
        	
        	int l = 0, r = c.length - 1;
        	boolean flag = true;
        	while(l <= r)
        	{
        		if(c[l] == c[r]) flag = true;
        		else flag = false;
        		l++;
        		r--;
        	}
        	
        	System.out.println(flag ? "Do-it" : "Do-it-Not");
        }
    }
}