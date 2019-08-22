import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++)
		{
			char[] c = sc.next().toCharArray();
			int[] arr = new int[10];
			int max = 0;
			for(int j = 0; j < c.length; j++)
			{
				if(j == 0)
					arr[c[j] - '0']++;
				else if(j > 0 && c[j-1] == c[j])
					arr[c[j] - '0']++;
				else
					arr[c[j] - '0'] = 1;
				if(max < arr[c[j] - '0'])
					max = arr[c[j] - '0'];
			}
			System.out.println(max);
		}
	}
}