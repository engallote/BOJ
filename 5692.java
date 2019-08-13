import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[20];
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i < 20; i++)
			arr[i] = arr[i-1] * i;
//		System.out.println(arr[19]);
		while(true)
		{
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			int num = 1, sum = 0;
			while(N > 0)
			{
				sum += (N % 10) * arr[num];
				N /= 10;
				num++;
			}
			System.out.println(sum);
		}
	}
}