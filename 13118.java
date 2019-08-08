import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		
		for(int i = 0; i < 4; i++)
			arr[i] = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int r = sc.nextInt();
		int res = 0;
		for(int i = 0; i < 4; i++)
			if(arr[i] == x)
				res = i + 1;
		System.out.println(res);
	}
}