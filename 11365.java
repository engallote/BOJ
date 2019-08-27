import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			StringBuilder str = new StringBuilder();
			str.append(sc.nextLine());
			if(str.toString().equals("END"))
				break;
			str.reverse();
			System.out.println(str.toString());
		}
	}
}