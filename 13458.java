import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextLong();
        
        long B = sc.nextLong();
        long C = sc.nextLong();
        long res = 0;
        for(int i = 0; i < N; i++)
        {
        	if(arr[i] - B <= 0) res++;
        	else
        	{
        		arr[i] -= B;
        		res += 1;
        		res += (arr[i] / C) + (arr[i] % C > 0 ? 1 : 0);
        	}
        }
        System.out.println(res);
	}
}