import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(true)
		{
			int r = sc.nextInt();
			if(r == 0) break;
			int w = sc.nextInt();
			int l = sc.nextInt();
			
			double p = r * 2;
			double res = Math.sqrt(w * w + l * l);
//			System.out.println(p + " " + res);
			if((int)p >= res)
				System.out.println("Pizza " + c + " fits on the table.");
			else
				System.out.println("Pizza " + c + " does not fit on the table.");
			c++;
		}
	} 
}