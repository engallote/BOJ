import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		HashSet<String> hs = new HashSet<>();
		boolean flag = true;
		for(int i = 0; i < str.length; i++)
		{
			if(hs.contains(str[i])) flag = false;
			hs.add(str[i]);
		}
		
		System.out.println(flag ? "yes" : "no");
	}
}