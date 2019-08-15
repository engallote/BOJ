import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int idx = 1, finger = 1, sw = 1;
		
		while(idx < N)
			idx += 8;
		
		while(idx > N)
		{
			if(sw == 1) finger++; 
			else finger--;
			if(finger == 1 || finger == 5) sw *= -1;
			idx--;
		}
		System.out.println(finger);
	}
}