import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= N; i++)
		{
			String[] str = sc.nextLine().split(" ");
			int numA = Integer.parseInt(str[0]);
			int numB = Integer.parseInt(str[2]);
			int res = 0;
			switch(str[1]){
			case "+": res = numA + numB; break;
			case "-": res = numA - numB; break;
			}
			
			if(Integer.parseInt(str[4]) == res)
				System.out.println("Case " + i + ": YES");
			else
				System.out.println("Case " + i + ": NO");
		}
	}
}