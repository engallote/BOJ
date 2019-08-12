import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int az = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		int cz = sc.nextInt();
		
		//cx
		int bx = Math.abs(cx - az);
		//cy
		int by = cy / ay;
		//cz
		int bz = Math.abs(cz - ax);
		
		System.out.println(bx + " " + by + " " + bz);
	}
}