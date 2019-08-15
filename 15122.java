import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = N + 1;; i++)
			if(!Integer.toString(i).contains("0"))
			{
				System.out.println(i);
				break;
			}
	}
}