import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String res = "뭐야?";
		
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			if(name.equals("anj")) res = "뭐야;";
		}
		
		System.out.println(res);
	}
}