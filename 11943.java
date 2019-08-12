import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		System.out.println(Math.min(a1 + b, a + b1));
	}
}