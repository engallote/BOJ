import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] number = {"063", "010", "093", "079", "106", "103", "119", "011", "127", "107"};
        while(true)
        {
        	String st = sc.next();
        	if(st.equals("BYE")) break;
        	int start = 0, len = st.length();
        	boolean[] chk = new boolean[10];
        	String num1 = "", num2 = "";
        	for(int i = 0; i < len; i+=3)
        	{
        		if(st.charAt(i) == '+')
        		{
        			start = i + 1;
        			break;
        		}
        		String s = st.charAt(i) + "" + st.charAt(i+1) + "" + st.charAt(i+2);
        		char[] c = Integer.toBinaryString(Integer.parseInt(s)).toCharArray();
        		Arrays.fill(chk, false);
        		int idx = 0;
        		for(int j = c.length - 1; j >= 0; j--)
        		{
        			if(c[j] == '1')
        				chk[idx] = true;
        			idx++;
        		}
        		for(int j = 0; j < 10; j++)
            	{
        			if(s.equals(number[j]))
        			{
        				num1 += j;
        				break;
        			}
            	}
        	}
        	
        	for(int i = start; i < len; i+=3)
        	{
        		if(st.charAt(i) == '=') break;
        		String s = st.charAt(i) + "" + st.charAt(i+1) + "" + st.charAt(i+2);
        		char[] c = Integer.toBinaryString(Integer.parseInt(s)).toCharArray();
        		Arrays.fill(chk, false);
        		int idx = 0;
        		for(int j = c.length - 1; j >= 0; j--)
        		{
        			if(c[j] == '1')
        				chk[idx] = true;
        			idx++;
        		}
        		for(int j = 0; j < 10; j++)
            	{
        			if(s.equals(number[j]))
        			{
        				num2 += j;
        				break;
        			}
            	}
        	}
//        	System.out.println(num1);
//        	System.out.println(num2);
        	int res = Integer.parseInt(num1) + Integer.parseInt(num2);
        	char[] c = Integer.toString(res).toCharArray();
        	String resCode = "";
        	for(int i = 0; i < c.length; i++)
        		resCode += number[c[i]-'0'];
        	
        	StringBuilder ans = new StringBuilder();
        	ans.append(st);
        	ans.append(resCode);
        	System.out.println(ans.toString());
        }
    }
}