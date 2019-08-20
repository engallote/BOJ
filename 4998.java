import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
        	double N = sc.nextDouble();
        	double B = sc.nextDouble();
        	double M = sc.nextDouble();
        	int res = 0;
        	
        	while(N < M)
        	{
        		res++;
        		N += (N * (B / 100));
        	}
        	System.out.println(res);
        }
    }
}