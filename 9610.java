import java.util.*;

public class Main {
	static boolean flag;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[5];
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x > 0 && y > 0) arr[0]++;
			else if(x < 0 && y > 0) arr[1]++;
			else if(x < 0 && y < 0) arr[2]++;
			else if(x > 0 && y < 0) arr[3]++;
			else arr[4]++;
		}
		
		for(int i = 0; i < 5; i++)
		{
			if(i == 4)
				System.out.println("AXIS: " + arr[i]);
			else
				System.out.println("Q" + (i + 1) + ": " + arr[i]);
		}
	}
}