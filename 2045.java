import java.util.*;

public class Main {
	static int number = -1, max = 0;
	static boolean end = false;
	static int[][] arr = new int[3][3];
	static int[] sumNum = new int[8];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean alr = false;
        for(int i = 0; i < 3; i++)
        {
        	boolean flag = true;
        	int sum = 0;
        	for(int j = 0; j < 3; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		sum += arr[i][j];
        		if(arr[i][j] == 0)
        			flag = false;
        	}
        	if(flag && !alr)
        	{
        		alr = true;
        		number = sum;
        	}
        }
        if(!alr)
        {
        	for(int i = 0; i < 3; i++)
            {
            	boolean flag = true;
            	int sum = 0;
            	for(int j = 0; j < 3; j++)
            	{
            		if(arr[j][i] == 0)
            		{
            			flag = false;
            			break;
            		}
            		sum += arr[j][i];
            	}
            	if(flag)
            	{
            		number = sum;
            		alr = true;
            		break;
            	}
            }
        }
        if(!alr)
        {
        	if(arr[1][1] == 0)
        	{
        		if(arr[0][0] == 0)
        			find(1);
        		else
        			find(2);
        	}
        	else
        	{
        		number = Math.max(arr[0][0] + arr[1][1] + arr[2][2], arr[0][2] + arr[1][1] + arr[2][0]);
        		alr = true;
        	}
        }
        if(alr)
        {
        	while(true)
        	{
        		boolean zero = false;
        		for(int i = 0; i < 3; i++)
            	{
            		for(int j = 0; j < 3; j++)
            			if(arr[i][j] == 0)
            			{
            				zero = true;
            				int sum = 0, cnt = 0;
            				for(int k = 0; k < 3; k++)
            				{
            					if(arr[i][k] == 0) cnt++;
            					sum += arr[i][k];
            				}
            				if(cnt == 1)
            					arr[i][j] = number - sum;
            				else
            				{
            					sum = 0;
            					cnt = 0;
            					for(int k = 0; k < 3; k++)
                				{
                					if(arr[k][j] == 0) cnt++;
                					sum += arr[k][j];
                				}
            					if(cnt == 1)
                					arr[i][j] = number - sum;
            				}
            			}
            	}
        		if(!zero) break;
        	}
        }
        for(int i = 0; i < 3; i++)
        {
        	for(int j = 0; j < 3; j++)
        		System.out.print(arr[i][j] + " ");
        	System.out.println();
        }
    }
	private static void find(int n) {
		int a, b, c, d, e, f, g, h;
		if(n == 1)
		{
			for(int i = 1; i <= 20000; i++)
			{
				arr[0][0] = i;
				a = i + arr[0][1] + arr[0][2];
				b = arr[1][0] + arr[1][2];
				arr[1][1] = a - b;
				if(arr[1][1] <= 0) continue;
				b += arr[1][1];
				c = arr[2][0] + arr[2][1];
				arr[2][2] = a - c;
				if(arr[2][2] <= 0) continue;
				c += arr[2][2];
				d = arr[0][0] + arr[1][0] + arr[2][0];
				e = arr[0][1] + arr[1][1] + arr[2][1];
				f = arr[0][2] + arr[1][2] + arr[2][2];
				g = arr[0][0] + arr[1][1] + arr[2][2];
				h = arr[0][2] + arr[1][1] + arr[2][0];
				if(a == b && b == c && c == d && d == e && e == f && f == g && g == h)
					return;
				arr[0][0] = arr[1][1] = arr[2][2] = 0;
			}
		}
		else
		{
			for(int i = 1; i <= 20000; i++)
			{
				arr[0][2] = i;
				a = i + arr[0][0] + arr[0][1];
				b = arr[1][0] + arr[1][2];
				arr[1][1] = a - b;
				if(arr[1][1] <= 0) continue;
				b += arr[1][1];
				c = arr[2][1] + arr[2][2];
				arr[2][0] = a - c;
				if(arr[2][0] <= 0) continue;
				c += arr[2][0];
				d = arr[0][0] + arr[1][0] + arr[2][0];
				e = arr[0][1] + arr[1][1] + arr[2][1];
				f = arr[0][2] + arr[1][2] + arr[2][2];
				g = arr[0][0] + arr[1][1] + arr[2][2];
				h = arr[0][2] + arr[1][1] + arr[2][0];
				if(a == b && b == c && c == d && d == e && e == f && f == g && g == h)
					return;
				arr[0][2] = arr[1][1] = arr[2][0] = 0;
			}
		}
	}
}