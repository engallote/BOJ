import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int[] arr = {13, 13, 13, 13};
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < c.length; i+=3)
		{
			if(c[i] == 'P') arr[0]--;
			else if(c[i] == 'K') arr[1]--;
			else if(c[i] == 'H') arr[2]--;
			else arr[3]--;
			
			String str = new String(c[i]+""+c[i+1]+""+c[i+2]);
			if(hs.contains(str))
			{
				System.out.println("GRESKA");
				return;
			}
			hs.add(str);
		}
		
		for(int i = 0; i < 4; i++)
			System.out.print(arr[i] + " ");
	}
}