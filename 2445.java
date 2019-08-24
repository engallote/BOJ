import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int jump = N-1, cnt = 1;
		
		while(true)
		{
			for(int i = 0; i < cnt; i++)
				System.out.print("*");
			for(int i = 0; i < jump; i++)
				System.out.print(" ");
			for(int i = 0; i < jump; i++)
				System.out.print(" ");
			for(int i = 0; i < cnt; i++)
				System.out.print("*");
			cnt++;
			jump--;
			System.out.println();
			if(cnt > N) break;
		}
		
		cnt = N-1;
		jump = 1;
		while(true)
		{
			for(int i = 0; i < cnt; i++)
				System.out.print("*");
			for(int i = 0; i < jump; i++)
				System.out.print(" ");
			for(int i = 0; i < jump; i++)
				System.out.print(" ");
			for(int i = 0; i < cnt; i++)
				System.out.print("*");
			cnt--;
			jump++;
			if(cnt < 1) break;
			System.out.println();
		}
	}
}