import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int cnt = 0;
			while(n >= k)
			{
				n -= k;
				n += 1;
				cnt += k;
			}
			if(n > 0)
				cnt += n;
			System.out.println(cnt);
		}
	} 
}