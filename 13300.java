import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[7][2];
        for(int i = 0; i < N; i++)
        {
            int s = sc.nextInt();
            int y = sc.nextInt();
            arr[y][s]++;
        }
        
        int res = 0;
        for(int i = 1; i <= 6; i++)
        {
            res += (arr[i][0] / K) + (arr[i][0] % K > 0 ? 1 : 0);
            res += (arr[i][1] / K) + (arr[i][1] % K > 0 ? 1 : 0);
        }
        System.out.println(res);
    }
}