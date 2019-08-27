import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 4;
		
		if(N < 0)
			System.out.println((char)((12+N)+'A')+""+(10+N));
		else
			System.out.println((char)(N%12+'A')+""+(N%10));
	}
}