import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(N));
		sb.reverse();
		
		System.out.println(Integer.parseInt(sb.toString(), 2));
	}
}