import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0 ; t < tc; t++)
        {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	Arrays.sort(arr);
        	
        	long res = 0;
        	for(int i = 0; i < N - 1; i++)
        	{
        		for(int j = i+1; j < N; j++)
        			res += gcd(arr[i], arr[j]);
        	}
        	System.out.println(res);
        }
    }

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}