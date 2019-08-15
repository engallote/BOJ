import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int[] arr = new int[3];
		arr[0] = 1;
		int tmp = 0;
		for(char ch : c)
		{
			if(ch == 'A')
			{
				tmp = arr[0];
				arr[0] = arr[1];
				arr[1] = tmp;
			}
			else if(ch == 'B')
			{
				tmp = arr[1];
				arr[1] = arr[2];
				arr[2] = tmp;
			}
			else if(ch == 'C')
			{
				tmp = arr[2];
				arr[2] = arr[0];
				arr[0] = tmp;
			}
		}
		
		if(arr[0] == 1) System.out.println(1);
		else if(arr[1] == 1) System.out.println(2);
		else System.out.println(3);
	}
}