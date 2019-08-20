import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int one = 0, two = 0, eig = 0, zero = 0;
        int other = 0;
        while(N > 0)
        {
        	if(N%10 == 0) zero++;
        	else if(N%10 == 1) one++;
        	else if(N%10 == 2) two++;
        	else if(N%10 == 8) eig++;
        	else other++;
        	N /= 10;
        }
        
        if(other > 0) System.out.println(0);
        else if(one == zero && zero == two && two == eig && one > 0)
        	System.out.println(8);
        else if(one > 0 && two > 0 && zero > 0 && eig > 0)
        	System.out.println(2);
        else if(one > 0 || two > 0 || zero > 0 || eig > 0)
        	System.out.println(1);
    }
}