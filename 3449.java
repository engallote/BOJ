import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int res = 0;
			
			for(int i = 0; i < a.length; i++)
				if(a[i] != b[i]) res++;
			System.out.println("Hamming distance is " + res + ".");
		}
	}
}