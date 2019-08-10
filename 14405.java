import java.util.*;

public class Main {
	static String[] arr = {"pi", "ka", "chu"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(s.contains(arr[0]))
			s = s.replaceAll(arr[0], " ");
		if(s.contains(arr[1]))
			s = s.replaceAll(arr[1], " ");
		if(s.contains(arr[2]))
			s = s.replaceAll(arr[2], " ");
//		System.out.println(s);
		s = s.trim();
		if(s.length() > 0)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}