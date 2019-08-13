import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while(sc.hasNext())
		{
			int num = sc.nextInt();
			if(num == 1) sum += 500;
			else if(num == 2) sum += 800;
			else sum += 1000;
		}
		System.out.println(5000-sum);
	}
}