import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0, num = 0;
        char[] order = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 2; i <= N; i++)
        {
        	int sum = 0, tmp = N;
        	
        	while(tmp > 0)
        	{
        		sum += tmp % i;
        		tmp /= i;
        	}

        	if(res < sum)
        	{
        		res = sum;
        		num = i;
        	}
        }
        System.out.println(res + " " + num);
    }
}