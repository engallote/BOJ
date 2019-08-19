import java.util.*;

public class Main {
	static int W, H, res;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        int N = sc.nextInt();
        res = 0;
        
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        
        for(int i = 1; i < N; i++)
        {
        	int x = sc.nextInt();
            int y = sc.nextInt();
            if(sx < x && sy < y)
            {
            	while(sx < x && sy < y)
                {
                	sx++;
                	sy++;
                	res++;
                }
            }
            else if(sx > x && sy > y)
            {
            	while(sx > x && sy > y)
                {
                	sx--;
                	sy--;
                	res++;
                }
            }
//            System.out.println(res);
            res += (Math.abs(sx - x) + Math.abs(sy - y));
//            System.out.println(" > " + res);
            sx = x;
            sy = y;
        }
        System.out.println(res);
	}
}