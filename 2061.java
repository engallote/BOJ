import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] chk = new boolean[1000001];
        chk[0] = chk[1] = true;
        Vector<Integer> v = new Vector<>();
        for(int i = 2; i <= 1000000; i++)
        {
        	if(chk[i]) continue;
        	v.add(i);
        	for(int j = i+i; j <= 1000000; j+=i)
        		chk[j] = true;
        }
        
        BigInteger K = new BigInteger(sc.next());
        int L = sc.nextInt();
        boolean flag = true, next = false;
        int min = Integer.MAX_VALUE;
        BigInteger mod;
        while(true)
        {
        	next = false;
//        	System.out.println(K);
        	for(int i = 0; i < v.size(); i++)
        	{
        		mod = K.mod(new BigInteger(Integer.toString(v.get(i))));
        		if(mod.compareTo(BigInteger.ZERO) == 0)
            	{
        			next = true;
        			if(v.get(i) < L)
        			{
        				flag = false;
        				min = Math.min(min, v.get(i));
        				break;
        			}
            		K = K.divide(new BigInteger(Integer.toString(v.get(i))));
            		if(K.compareTo(BigInteger.ZERO) == 0 || K.compareTo(BigInteger.ONE) == 0) break;
            	}
        	}
        	if(!next || !flag) break;
        	if(K.compareTo(BigInteger.ZERO) == 0 || K.compareTo(BigInteger.ONE) == 0) break;
        }
        if(flag)
        	System.out.println("GOOD");
        else
        	System.out.println("BAD " + min);
    }
}