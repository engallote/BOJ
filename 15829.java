import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mod = 1234567891;
        char[] c = sc.next().toCharArray();
        long res = 0, cnt = 1;
        for(int i = 0; i < N; i++)
        {
        	res += (((c[i] - 'a') + 1) * cnt);
        	cnt *= 31;
        	cnt %= mod;
        }
        System.out.println(res%mod);
    }
}