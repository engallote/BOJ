import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0; t < tc; t++)
        {
        	double N = sc.nextDouble();
        	System.out.printf("$%.2f\n", (N * 0.8));
        }
    }
}