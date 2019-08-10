import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		int[] arr2 = new int[2];
		for(int i = 0; i < 4; i++)
			arr[i] = sc.nextInt();
		for(int i = 0; i < 2; i++)
			arr2[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		int sum = arr[3] + arr[2] + arr[1] + arr2[1];
		System.out.println(sum);
	}
}