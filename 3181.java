import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		HashSet<String> hs = new HashSet<>();
		hs.add("i");
		hs.add("pa");
		hs.add("te");
		hs.add("ni");
		hs.add("niti");
		hs.add("a");
		hs.add("ali");
		hs.add("nego");
		hs.add("no");
		hs.add("ili");
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < str.length; i++)
		{
			if(i == 0)//¹«Á¶°Ç
				ans.append(str[0].toUpperCase().charAt(0));
			else
			{
				if(hs.contains(str[i])) continue;
				ans.append(str[i].toUpperCase().charAt(0));
			}
		}
		System.out.println(ans.toString());
	}
}