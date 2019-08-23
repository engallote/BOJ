import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[21];
		
		for(int i = 1; i <= 20; i++)
			arr[i] = i;
		
		for(int k = 0; k < 10; k++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a > b)
			{
				int tmp = b;
				b = a;
				a = tmp;
			}
			while(a <= b){
				int tmp = arr[a];
				arr[a] = arr[b];
				arr[b] = tmp;
				a++;
				b--;
			}
		}
		
		for(int i = 1; i <= 20; i++)
			System.out.print(arr[i] + " ");
	}
}