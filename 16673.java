import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long c = sc.nextLong();
        long k = sc.nextLong();
        long p = sc.nextLong();
        
        long sum = 0;
        for(int i = 1; i <= (int)c; i++)
        	sum += (k * i) + (p * (i * i));
        
        System.out.println(sum);
    }
}