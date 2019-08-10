import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		arr[0] = 1;
		arr[3] = 2;
		
		char[] c = sc.next().toCharArray();
		
		for(int i = 0; i < c.length; i++)
		{
			if(c[i]=='A')
			{
				int tmp = arr[0];
				arr[0] = arr[1];
				arr[1] = tmp;
			}
			else if(c[i] == 'B')
			{
				int tmp = arr[0];
				arr[0] = arr[2];
				arr[2] = tmp;
			}
			else if(c[i] == 'C')
			{
				int tmp = arr[0];
				arr[0] = arr[3];
				arr[3] = tmp;
			}
			else if(c[i] == 'D')
			{
				int tmp = arr[1];
				arr[1] = arr[2];
				arr[2] = tmp;
			}
			else if(c[i] == 'E')
			{
				int tmp = arr[1];
				arr[1] = arr[3];
				arr[3] = tmp;
			}
			else if(c[i] == 'E')
			{
				int tmp = arr[2];
				arr[2] = arr[3];
				arr[3] = tmp;
			}
		}
		
		int n = 0, m = 0;
		for(int i = 0; i < 4; i++)
		{
			if(arr[i] == 1)
				m = i + 1;
			if(arr[i] == 2)
				n = i + 1;
		}
		
		System.out.println(m);
		System.out.println(n);
	}
}