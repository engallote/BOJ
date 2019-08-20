import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        int len = c.length, min;
        boolean[] chk = new boolean[len];
        int cnt = 0;
        while(cnt < len)
        {
        	int idx = 100;
        	min = 30;
        	for(int i = len - 1; i >= 0; i--)
        	{
        		if(!chk[i] && min >= c[i] - 'A')
        		{
        			min = c[i] - 'A';
        			idx = i;
        		}
        		if(chk[i] && idx != 100) break;
        	}
        	chk[idx] = true;
        	String s = "";
        	for(int i = 0; i < len; i++)
        		if(chk[i])
        			s += ""+c[i];
        	System.out.println(s);
        	cnt++;
        }
    }
}