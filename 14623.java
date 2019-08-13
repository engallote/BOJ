import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next(),2);
		long b = Long.parseLong(sc.next(),2);
		long res = a * b;
		System.out.println(Long.toString(res, 2));
	}
}