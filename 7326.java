import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] arr = new int[5001][5001];
        for(int i = 0; i <= 5000; i++)
        	Arrays.fill(arr[i], -1);
        int start = 0, jump = 1;
        for(int i = 0; i <= 5000; i++)
        {
        	arr[i][i] = start;
        	if(i + 2 <= 5000)
        		arr[i+2][i] = start + 2;
        	start += jump;
        	if(jump == 1) jump = 3;
        	else jump = 1;
        }
        
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	if(arr[a][b] == -1)
        		System.out.println("No Number");
        	else System.out.println(arr[a][b]);
        }
	}
}