import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			System.out.println(arr[7]);	
		}
	}
}