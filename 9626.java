import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int U = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int D = sc.nextInt();
        int row = M + U + D, col = N + L + R;
        char[][] arr = new char[row][col];
        
        int sw = 1;
        char c = '#';
        for(int i = 0; i < row; i++)
        {
        	if(sw == 1)
        	{
        		c = '#';
        		sw *= -1;
        	}
        	else
        	{
        		c = '.';
        		sw *= -1;
        	}
        	for(int j = 0; j < col; j++)
        	{
        		arr[i][j] = c;
        		if(c == '#')
        			c = '.';
        		else
        			c = '#';
        	}
        }
        
        char[][] str = new char[M][N];
        
        for(int i = 0; i < M; i++)
        	str[i] = sc.next().toCharArray();
        
        int idx = 0, cIdx = 0;
        for(int i = U; i < row; i++)
        {
        	cIdx = 0;
        	for(int j = L; j < col; j++)
        	{
        		arr[i][j] = str[idx][cIdx];
        		cIdx++;
        		if(cIdx == N) break;
        	}
        	idx++;
        	if(idx == M) break;
        }
        
        for(int i = 0; i < row; i++)
        {
        	for(int j = 0; j < col; j++)
        		System.out.print(arr[i][j]);
        	System.out.println();
        }  
    }
}