import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();
        for(int t = 0; t < tc; t++)
        {
        	int N = sc.nextInt();
        	int ans = 0;
        	for(int i = 1; i < Math.sqrt(N); i++)
        	{
        		if(i + (i * i) <= N) ans = i;
        		else break;
        	}
        	System.out.println(ans);
        }
    }
}