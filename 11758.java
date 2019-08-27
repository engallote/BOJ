import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3], y = new int[3];
		
		for(int i = 0; i < 3; i++)
		{
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		int sum = (x[1] - x[0]) * (y[2] - y[0]) - (y[1] - y[0]) * (x[2] - x[0]);
		if(sum > 0)
			System.out.println(1);
		else if(sum == 0)
			System.out.println(0);
		else
			System.out.println(-1);
	}
}