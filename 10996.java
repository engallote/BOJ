import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len = 1;
        for(int i = 1; i < N; i++)
        	len += 4;
        char[][] arr = new char[len][len];
        for(int i = 0; i < len; i++) Arrays.fill(arr[i], ' '); 
        int start = 0, end = len - 1;
        while(N > 0)
        {
        	for(int i = start; i <= end; i++)
            {
            	if(i == start || i == end)
            		for(int j = start; j <= end; j++) arr[i][j] = '*';
            	else arr[i][start] = arr[i][end] = '*';
            }
        	end -= 2;
        	start += 2;
        	N--;
        }
        
        for(int i = 0; i < len; i++)
        {
        	for(int j = 0; j < len; j++)
        		System.out.print(arr[i][j]);
        	System.out.println();
        }
	}
}