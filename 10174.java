import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < N; i++)
        {
        	char[] c = sc.nextLine().toLowerCase().toCharArray();
        	boolean flag = true;
        	int l = 0, r = c.length - 1;
        	while(l <= r)
        	{
        		if(c[l] == c[r])
        		{
        			l++;
        			r--;
        		}
        		else
        		{
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag)
        		System.out.println("Yes");
        	else
        		System.out.println("No");
        }
    }
}