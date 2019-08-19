import java.util.*;

public class Main {
	static int N;
	static long res;
	static long[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 0;
        while(true)
        {
        	++tc;
        	String str = sc.next();
        	if(str.equals("0")) break;
        	char[] c = str.toCharArray();
        	int len = c.length;        	
        	int pre = c[0] - '0';
        	
        	if(pre != 1)
        	{
        		System.out.println(tc + ". NOT");
        		continue;
        	}
        	
        	boolean flag = true;
        	for(int i = 1; i < len; i++)
        	{
        		switch(c[i]-'0'){
        		case 1: flag = false; break;
        		case 2: 
        			if(pre == 4 || pre == 6) pre = 2;
        			else flag = false;
        			break;
        		case 3: 
        			if(pre == 4 || pre == 6) pre = 3;
        			else flag = false;
        			break;
        		case 4:
        			if(pre == 1 || pre == 3) pre = 4;
        			else flag = false;
        			break;
        		case 5:
        			if(pre == 1 || pre == 3) pre = 5;
        			else flag = false;
        			break;
        		case 6:
        			if(pre == 8) pre = 6;
        			else flag = false;
        			break;
        		case 7:
        			if(pre == 8) pre = 7;
        			else flag = false;
        			break;
        		case 8:
        			if(pre == 5 || pre == 7) pre = 8;
        			else flag = false;
        			break;
        		}
        		if(!flag) break;
        	}
        	if(flag && pre == 2)
        		System.out.println(tc + ". VALID");
        	else
        		System.out.println(tc + ". NOT");
        }
	}
}