import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++)
			arr[i] = sc.nextInt();
		int res = 0;
		for(int i = 0; i < 3; i++)
		{
			arr[i] -= sc.nextInt();
			if(arr[i] < 0) res += Math.abs(arr[i]);
		}
		
		System.out.println(res);
	}
}