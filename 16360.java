import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			int len = c.length;
			for(int j = 0; j < len; j++)
			{
				if(j == len - 2 && c[j] == 'n' && c[j+1] == 'e')
				{
					System.out.println("anes");
					break;
				}
				else if(j == len - 1)
				{
					if(c[j] == 'a') System.out.println("as");
					else if(c[j] == 'o') System.out.println("os");
					else if(c[j] == 'u') System.out.println("us");
					else if(c[j] == 'i' || c[j] == 'y') System.out.println("ios");
					else if(c[j] == 'l') System.out.println("les");
					else if(c[j] == 'n') System.out.println("anes");
					else if(c[j] == 'r') System.out.println("res");
					else if(c[j] == 't') System.out.println("tas");
					else if(c[j] == 'v') System.out.println("ves");
					else if(c[j] == 'w') System.out.println("was");
					else System.out.println(c[j]+"us");
				}
				else System.out.print(c[j]);
			}
		}
	}
}