import java.util.*;

public class Main {
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++)
			arr[i] = sc.nextInt();
		
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i = 0; i < 4; i++)
				if(arr[i] > arr[i+1])
				{
					flag = true;
					break;
				}
			
			for(int i = 0; i < 4; i++)
			{
				if(arr[i] > arr[i+1])
				{
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					for(int k : arr)
						System.out.print(k + " ");
					System.out.println();
				}
			}	
		}
	}
}