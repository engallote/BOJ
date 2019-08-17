import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(max < num) max = num;
			if(min > num) min = num;
		}
		System.out.println(min + " " + max);
	}
}