import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ori = sc.next().toCharArray();
        int N = sc.nextInt();
        double max = 0;
        String ans = "No Jam";
        int M, no;
        for(int i = 0; i < N; i++)
        {
        	no = 0;
        	char[] s = sc.next().toCharArray();
        	M = sc.nextInt();
        	int idx = 0;
        	for(int j = 0; j < s.length; j++)
        	{
        		if(idx < ori.length && s[j] == ori[idx])
        			idx++;
        		else no++;
        	}
        	
        	if(idx == ori.length)
        	{
        		double tmp = (double) M / no;
        		if(tmp > max)
        		{
        			ans = "";
        			max = tmp;
        			for(int j = 0; j < s.length; j++)
        				ans += "" + s[j];
        		}        		
        	}
        }
        
        System.out.println(ans);
    }
}