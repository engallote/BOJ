import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aA = sc.nextInt();
		int aL = sc.nextInt();
		int bA = sc.nextInt();
		int bL = sc.nextInt();
		
		while(aL > 0 && bL > 0)
		{
			bL -= aA;
			aL -= bA;
		}
//		System.out.println(aL + " " + bL);
		if(aL > 0 && bL <= 0)
			System.out.println("PLAYER A");
		else if(aL <= 0 && bL <= 0)
			System.out.println("DRAW");
		else if(aL <= 0 && bL > 0)
			System.out.println("PLAYER B");
	}
}