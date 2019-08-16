import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	String str = sc.next();
        	if(str.equals("end"))
        	{
        		System.out.print("end");
        		break;
        	}
        	
        	char[] c = str.toCharArray();
            char[][] arr = new char[7][29];
            for(int i = 0; i < 7; i++)
            	Arrays.fill(arr[i], ' ');
            int start = 0;
            for(int t = 0; t < c.length; t++)
            {
            	if(c[t] >= '0' && c[t] <= '9')
            	{
            		if(c[t] == '1')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            					arr[i][start + 4] = '+';
            				else
            					arr[i][start + 4] = '|';
            			}
            		}
            		else if(c[t] == '2')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else if(i <= 2)
            					arr[i][start+4] = '|';
            				else
            					arr[i][start] = '|';
            			}
            		}
            		else if(c[t] == '3')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else
            					arr[i][start+4] = '|';
            			}
            		}
            		else if(c[t] == '4')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i <= 3)
            				{
            					if(i == 0)
            						arr[i][start] = arr[i][start + 4] = '+';
            					else if(i == 3)
            					{
            						for(int j = start; j < start + 5; j++)
            							arr[i][j] = (j == start || j == start + 4) ? '+' : '-';
            					}
            					else arr[i][start] = arr[i][start + 4] = '|';
            				}
            				else
            				{
            					if(i == 6) arr[i][start + 4] = '+';
            					else arr[i][start + 4] = '|';
            				}
            			}
            		}
            		else if(c[t] == '5')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else if(i <= 2)
            					arr[i][start] = '|';
            				else
            					arr[i][start + 4] = '|';
            			}
            		}
            		else if(c[t] == '6')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else if(i <= 2)
            					arr[i][start] = '|';
            				else
            					arr[i][start] = arr[i][start + 4] = '|';
            			}
            		}
            		else if(c[t] == '7')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0)
            					for(int j = start; j < start + 5; j++)
            						arr[i][j] = (j == start || j == start + 4) ? '+' : '-';
            				else
            				{
            					if(i == 3 || i == 6) arr[i][start + 4] = '+';
            					else arr[i][start + 4] = '|';
            				}
            			}
            		}
            		else if(c[t] == '8')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else
            					arr[i][start] = arr[i][start + 4] = '|';
            			}
            		}
            		else if(c[t] == '9')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 3 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else if(i <= 2) arr[i][start] = arr[i][start + 4] = '|';
            				else arr[i][start + 4] = '|';
            			}
            		}
            		else if(c[t] == '0')
            		{
            			for(int i = 0; i < 7; i++)
            			{
            				if(i == 0 || i == 6)
            				{
            					for(int j = start; j < start + 5; j++)
            					{
            						if(j == start || j == start + 4)
            							arr[i][j] = '+';
            						else arr[i][j] = '-';
            					}
            				}
            				else if(i == 3) arr[i][start] = arr[i][start + 4] = '+';
            				else
            					arr[i][start] = arr[i][start + 4] = '|';
            			}
            		}
            		start += 7;
            	}
            	else
            	{
            		arr[2][start] = arr[4][start] = 'o';
            		start += 3;
            	}
            }
            
            for(int i = 0; i < 7; i++)
            {
            	for(int j = 0; j < 29; j++)
            		System.out.print(arr[i][j]);
            	System.out.println();
            }
            System.out.println();
            System.out.println();
        }
	}
}